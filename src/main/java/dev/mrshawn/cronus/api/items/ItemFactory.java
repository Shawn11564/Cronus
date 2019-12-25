package dev.mrshawn.cronus.api.items;

import dev.mrshawn.cronus.api.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemFactory {

	private ItemStack item;
	private Material material;
	private ItemMeta meta;
	private int amount;
	private List<String> lore;
	private String name;
	private List<Enchantment> enchantments;

	public ItemFactory(Material material, int amount) {
		this.material = material;
		this.amount = amount;
	}

	public ItemFactory(Material material, int amount, String name) {
		this.material = material;
		this.amount = amount;
		this.name = name;
	}

	private void init() {
		item = new ItemStack(material, amount);
		meta = Bukkit.getItemFactory().getItemMeta(material);
		if (meta != null) {
			if (name != null) {
				meta.setDisplayName(Chat.colorize(name));
			}
		}
	}
}
