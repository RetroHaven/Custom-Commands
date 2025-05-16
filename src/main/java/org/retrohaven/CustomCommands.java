package org.retrohaven;

import org.retrohaven.commands.MilkCommand;
import org.retrohaven.commands.PetCommand;
import org.retrohaven.commands.HugCommand;
import org.retrohaven.commands.MeowCommand;
import org.retrohaven.commands.SillyCommand;
import org.retrohaven.commands.WaveCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("meow").setExecutor(new MeowCommand());
        getCommand("hug").setExecutor(new HugCommand());
        getCommand("wave").setExecutor(new WaveCommand());
        getCommand("silly").setExecutor(new SillyCommand());
        getCommand("pet").setExecutor(new PetCommand());
        getCommand("milk").setExecutor(new MilkCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
