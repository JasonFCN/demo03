package com.cwj.demo03mcplugin.event;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

/**
 * @author Chenwujie
 * 2022/5/13 20:22
 */

public class MyEventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Location location = player.getLocation();
        World world = location.getWorld();
        world.playSound(location, Sound.ENTITY_PLAYER_LEVELUP, 0.5f, 0.5f);
        world.playEffect(location, Effect.MOBSPAWNER_FLAMES, null, 5);
        event.setJoinMessage(ChatColor.GREEN + "欢迎" + player.getName() + "来到服务器~");
    }

    @EventHandler
    public void onDamageSheep(EntityDamageByEntityEvent event){
        Entity damager = event.getDamager();
        Entity damagee = event.getEntity();
        if(damager instanceof Player && damagee instanceof Sheep){

            // 给羊羊君随机设置一种颜色
            Sheep sheep = (Sheep) damagee;
            DyeColor[] values = DyeColor.values();
            Random random = new Random();
            sheep.setColor(values[random.nextInt(values.length)]);

            // 取消伤害
            event.setCancelled(true);
        }

    }
}
