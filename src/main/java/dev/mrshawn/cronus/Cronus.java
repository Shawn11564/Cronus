package dev.mrshawn.cronus;

import org.bukkit.plugin.java.JavaPlugin;

public final class Cronus extends JavaPlugin {

	private static Cronus instance;

	@Override
	public void onEnable() {
		instance = this;
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	public static Cronus getInstance() {
		return instance;
	}

}
