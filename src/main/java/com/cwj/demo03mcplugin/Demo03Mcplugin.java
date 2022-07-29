package com.cwj.demo03mcplugin;

import com.cwj.demo03mcplugin.command.MyCommandExecutor;
import com.cwj.demo03mcplugin.event.MyEventListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class Demo03Mcplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // 1. 事件监听
        Bukkit.getPluginManager().registerEvents(new MyEventListener(), this);

        // 3. 自定义命令
        getCommand("god").setExecutor(new MyCommandExecutor());
        getCommand("suicide").setExecutor(new MyCommandExecutor());

        // 加载配置
        FileConfiguration config = getConfig();
        List<String> list = config.getStringList("list");
        getLogger().info(list.toString());
        String name = config.getString("map.name");
        int age = config.getInt("map.age");
        getLogger().info("name: " + name + " age: " + age);

        // 持久化配置
        config.set("map.age", 18);
        saveConfig();

        // 自定义配置
        YamlConfiguration myConfig = new YamlConfiguration();
        myConfig.set("hello", "world!");
        try {
            myConfig.save(new File(getDataFolder(), "custom-config.yml"));

            myConfig.load(new File(getDataFolder(), "custom-config.yml"));
            getLogger().info("hello: " + myConfig.getString("hello"));
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Demo03Mcplugin shutdown...");
    }
}
