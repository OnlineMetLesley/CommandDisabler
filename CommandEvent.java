package me.OnlineMetlesley.com.CommandDisabler;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class CommandEvent implements Listener{

	public Plugin instance;

	@SuppressWarnings("unused")
	private Main players;

	public CommandEvent() {

	}


	public void function() {
		Main plugin = (Main) Main.instance;
		plugin.getServer();
	}


	@EventHandler
	public void onCommandPlugins(PlayerCommandPreprocessEvent event) {
		Player player = (Player) event.getPlayer();
		for(String command : Main.instance.getConfig().getStringList("commands.commands")) {
			if (event.getMessage().toLowerCase().startsWith("/" + command)) {
				if (Main.instance.getConfig().getBoolean("commands.AllowPlayers")) {
					event.setCancelled(true);
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.instance.getConfig().getString("commands.BlockMessage")));
					if (Main.instance.getConfig().getBoolean("commands.Sounds")) {
						player.playSound(player.getLocation(), Sound.valueOf(Main.instance.getConfig().getString("commands.Sound").toUpperCase()), 10F, 100F);
					}
					if (Main.instance.getConfig().getBoolean("commands.Particles")) {
						player.spigot().playEffect(player.getLocation(), Effect.valueOf(Main.instance.getConfig().getString("commands.Particle").toUpperCase()),  0, 0, 0, 0, 0, (float) 0, 5, 30);
					}
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.instance.getConfig().getString("commands.BlockMessage")));
				}
			}
		}
	}
}
