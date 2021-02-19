package dev.mrshawn.cronus.api.items;

import de.tr7zw.changeme.nbtapi.NBTContainer;
import de.tr7zw.changeme.nbtapi.NBTItem;
import org.bukkit.inventory.ItemStack;

public class ItemUtils {

	public static boolean hasNBT(ItemStack item, String key) {
		NBTContainer nbtItem = NBTItem.convertItemtoNBT(item);
		return nbtItem.hasKey(key);
	}

	public static String getNBTString(ItemStack item, String key) {
		NBTContainer nbtItem = NBTItem.convertItemtoNBT(item);
		return nbtItem.getString(key);
	}

	public static int getNBTInt(ItemStack item, String key) {
		NBTContainer nbtItem = NBTItem.convertItemtoNBT(item);
		return nbtItem.getInteger(key);
	}

	public static boolean getNBTBoolean(ItemStack item, String key) {
		NBTContainer nbtItem = NBTItem.convertItemtoNBT(item);
		return nbtItem.getBoolean(key);
	}

}
