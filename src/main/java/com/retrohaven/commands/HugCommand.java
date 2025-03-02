package com.retrohaven.customcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HugCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return false;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("customcommands.hug")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Usage: /hug <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null || !target.isOnline()) {
            player.sendMessage(ChatColor.RED + "That player is not online.");
            return true;
        }

        if (player.getName() == target.getName()) {
            String message = ChatColor.LIGHT_PURPLE + player.getName() + " has hugged themselves! Awww";
        } else {
            String message = ChatColor.LIGHT_PURPLE + player.getName() + " has hugged " + target.getName() + "! Awww";
        }
        Bukkit.broadcastMessage(message);
        return true;
    }
}
