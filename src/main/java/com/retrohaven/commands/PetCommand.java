package com.retrohaven.customcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("customcommands.pet")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /pet <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null || !target.isOnline()) {
            player.sendMessage(ChatColor.RED + "That player is not online!");
            return true;
        }

        if (player.getName() == target.getName()) {
            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + player.getName() + " pets themselves :3");
        } else {
            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + player.getName() + " pets " + target.getName() + " :3");
        }
        return true;
    }
}
