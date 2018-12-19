package me.OnlineMetlesley.com.CommandDisabler;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.OnlineMetlesley.com.CommandDisabler.Commands;

public class Main extends JavaPlugin
implements Listener
{
	FileConfiguration config = getConfig();
	public File players;
	public FileConfiguration customConfig;
	Server getserver = getServer();
	public static Plugin instance;

	public Plugin getInstance()
	{
		return instance;
	}


	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		config.options().copyDefaults(true);
		Bukkit.getPluginManager().registerEvents(this, this);
		this.getCommand("commanddisabler").setExecutor(new Commands());
		Bukkit.getServer().getPluginManager().registerEvents(new CommandEvent(), this);

		@SuppressWarnings("unused")
		MetricsLite metrics = new MetricsLite(this);

	}
}