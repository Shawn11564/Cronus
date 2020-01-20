package dev.mrshawn.cronus.api.items;

import dev.mrshawn.cronus.api.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Map;
import java.util.UUID;

public class SkullBuilder extends ItemBuilder {

	private SkullMeta skullMeta;

	public SkullBuilder(Material material) {
		super(material);
		skullMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(material);
	}

	public SkullBuilder(Material material, int amount) {
		super(material, amount);
		skullMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(material);
	}

	public SkullBuilder(Material material, int amount, short damage) {
		super(material, amount, damage);
		skullMeta = (SkullMeta) Bukkit.getItemFactory().getItemMeta(material);
	}

	public void setOwner(UUID uuid) {
		skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(uuid));
	}

	public ItemStack build() {
		item = new ItemStack(material, amount, damage);
		skullMeta.setDisplayName(Chat.colorize(name));
		skullMeta.setLore(Chat.colorizeList(lore));
		item.setItemMeta(skullMeta);
		for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
			item.addUnsafeEnchantment(entry.getKey(), entry.getValue());
		}
		return item;
	}
}
