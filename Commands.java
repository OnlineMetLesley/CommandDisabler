package me.OnlineMetlesley.com.CommandDisabler;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Commands implements CommandExecutor{


	public Plugin instance;

	public Commands() {

	}


	public void function() {
		Main plugin = (Main) Main.instance;
		plugin.getServer();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("commanddisabler")) {
			if (player.hasPermission("commanddisabler.reload")) {
				if (args[0].equals("reload")) {
					Main.instance.reloadConfig();
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.instance.getConfig().getString("configReloaded")));
				}
				if (args[0].length() == 0) {
					player.sendMessage(ChatColor.RED + "Wrong usage! Use /cd reload to reload the config.yml");
				}
			} else {
				player.sendMessage(ChatColor.RED + "No Permissions.");
			}
		}
		return false;
	}

}