package dev.mrshawn.cronus.api.utils;

import dev.mrshawn.cronus.API;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class PlayerUtils {

	public static boolean isOnlinePlayer(String playerName) {
		return API.getPlugin().getServer().getPlayer(playerName) != null;
	}

	public static Player getOnlinePlayer(String playerName) {
		return API.getPlugin().getServer().getPlayer(playerName);
	}

	public static boolean isOfflinePlayer(String playerName) {
		return getOfflinePlayer(playerName).hasPlayedBefore();
	}

	public static OfflinePlayer getOfflinePlayer(String playerName) {
		return API.getPlugin().getServer().getOfflinePlayer(playerName);
	}

}
