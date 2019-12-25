package dev.mrshawn.cronus;

import org.bukkit.plugin.java.JavaPlugin;

public class API {

	private static JavaPlugin plugin;

	public static JavaPlugin getPlugin() {
		return plugin;
	}

	public static void setPlugin(JavaPlugin plugin) {
		API.plugin = plugin;
	}
}
