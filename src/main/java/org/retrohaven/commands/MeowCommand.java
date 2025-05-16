package org.retrohaven.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MeowCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return false;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("customcommands.meow")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true; // Returning true prevents the "Usage" message from appearing
        }

        String message = ChatColor.GOLD + "<" + player.getName() + "> Meow :3";
        player.getServer().broadcastMessage(message);
        return true;
    }
}
