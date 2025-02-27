package com.retrohaven.customcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MilkCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("customcommands.milk")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /milk <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null || !target.isOnline()) {
            player.sendMessage(ChatColor.RED + "That player is not online!");
            return true;
        }

        // Give the player a milk bucket
        ItemStack milkBucket = new ItemStack(Material.MILK_BUCKET);
        player.getInventory().addItem(milkBucket);

        // Send messages
        player.sendMessage(ChatColor.AQUA + "You have milked " + target.getName() + "!");
        target.sendMessage(ChatColor.YELLOW + player.getName() + " has milked you!");
        Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + " just milked " + target.getName() + "!");

        return true;
    }
}
