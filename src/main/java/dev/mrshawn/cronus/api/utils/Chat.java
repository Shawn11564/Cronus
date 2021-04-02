package dev.mrshawn.cronus.api.utils;

import dev.mrshawn.cronus.API;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Chat {

	public static void log(String... messages) {
		for (final String message : messages)
			log(message);
	}

	public static void log(String messages) {
		tell(Bukkit.getConsoleSender(), "[" + API.getPlugin().getName() + "] " + messages);
	}

	public static void tell(CommandSender toWhom, String... messages) {
		for (final String message : messages)
			tell(toWhom, message);
	}

	public static void tell(CommandSender toWhom, List<String> messages) {
		for (final String message : messages)
			tell(toWhom, message);
	}

	public static void tell(CommandSender toWhom, String message) {
		toWhom.sendMessage(colorize(message));
	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public static List<String> colorizeList(List<String> list) {
		List<String> temp = new ArrayList<>();
		for (String s : list)
			temp.add(colorize(s));
		return temp;
	}

	public static String strip(String text) {
		return ChatColor.stripColor(colorize(text));
	}

	public static List<String> strip(List<String> list) {
		List<String> temp = new ArrayList<>();
		for (String s : colorizeList(list)) {
			temp.add(ChatColor.stripColor(s));
		}
		return temp;
	}

	public static int getLength(String text, boolean ignoreColorCodes) {
		return ignoreColorCodes ? strip(text).length() : text.length();
	}

}
