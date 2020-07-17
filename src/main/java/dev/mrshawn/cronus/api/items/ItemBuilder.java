package dev.mrshawn.cronus.api.items;

import de.tr7zw.changeme.nbtapi.NBTItem;
import dev.mrshawn.cronus.api.utils.Chat;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ItemBuilder {

	private ItemStack item;
	private Material material;
	private int amount;
	private ItemMeta meta;
	private List<String> lore = new ArrayList<>();
	private Map<Enchantment, Integer> enchants = new HashMap<>();
	private NBTItem nbtItem;

	public ItemBuilder(Material material) {
		this.material = material;
		amount = 1;
		item = new ItemStack(this.material, amount);
		meta = item.getItemMeta();
		nbtItem = new NBTItem(item);
	}

	public ItemBuilder(Material material, int amount) {
		this.material = material;
		this.amount = amount;
		item = new ItemStack(this.material, amount);
		meta = item.getItemMeta();
		nbtItem = new NBTItem(item);
	}

	public ItemBuilder setName(String name) {
		meta.setDisplayName(Chat.colorize(name));
		return this;
	}

	public ItemBuilder addLoreLine(String line) {
		lore.add(Chat.colorize(line));
		return this;
	}

	public ItemBuilder addEnchant(Enchantment type, int level) {
		enchants.put(type, level);
		return this;
	}

	public ItemBuilder setAmount(int amount) {
		this.amount = amount;
		item.setAmount(this.amount);
		return this;
	}

	public ItemBuilder addNBT(String key, String value) {
		nbtItem.setString(key, value);
		return this;
	}

	public ItemBuilder addNBT(String key, int value) {
		nbtItem.setInteger(key, value);
		return this;
	}

	public ItemBuilder addNBT(String key, boolean value) {
		nbtItem.setBoolean(key, value);
		return this;
	}


	public ItemStack build() {
		meta.setLore(lore);
		enchants.forEach((key, value) -> item.addUnsafeEnchantment(key, value));
		item.setItemMeta(meta);
		return item;
	}
}