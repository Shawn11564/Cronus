package dev.mrshawn.cronus.api.utils;

import org.bukkit.ChatColor;

public class ColorUtils {

	public static boolean isColorCode(String name) {
		for (ChatColor color : ChatColor.values()) {
			if (color.name().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	public static ChatColor getColorCodeByName(String name) {
		for (ChatColor color : ChatColor.values()) {
			if (color.name().equalsIgnoreCase(name)) {
				return color;
			}
		}
		return null;
	}

}
