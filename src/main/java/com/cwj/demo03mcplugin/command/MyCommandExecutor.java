package com.cwj.demo03mcplugin.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Chenwujie
 * 2022/5/14 11:05
 */

public class MyCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (label){
            case "god":
                if(sender instanceof Player){
                    Player player = (Player)sender;
                    player.setInvulnerable(!player.isInvulnerable());
                    sender.sendMessage(ChatColor.WHITE + "现在切换成" + (player.isInvulnerable() ? "上帝模式" : "非上帝模式"));
                }else{
                    sender.sendMessage("<god>命令只有玩家才能使用");
                }
                return true;
            case "suicide":
                if(sender instanceof Player){
                    Player player = (Player)sender;
                    player.setHealth(0D);
                    sender.sendMessage(ChatColor.RED + "你离开了这个世界。。。");
                }else{
                    sender.sendMessage("<suicide>命令只有玩家才能使用");
                }
                return true;
            default:
                return false;
        }
    }
}
