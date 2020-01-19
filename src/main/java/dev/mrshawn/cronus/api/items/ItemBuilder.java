package dev.mrshawn.cronus.api.items;

import dev.mrshawn.cronus.api.utils.Chat;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ItemBuilder {

	protected ItemStack item;
	protected Material material;
	protected ItemMeta meta;
	protected int amount;
	protected short damage;
	protected List<String> lore;
	protected String name;
	protected Map<Enchantment, Integer> enchantments = new HashMap<>();

	public ItemBuilder(Material material) {
		this.material = material;
		amount = 1;
		damage = (short) 0;
		meta = Bukkit.getItemFactory().getItemMeta(material);
	}

	public ItemBuilder(Material material, int amount) {
		this.material = material;
		this.amount = amount;
		damage = (short) 0;
		meta = Bukkit.getItemFactory().getItemMeta(material);
	}

	public ItemBuilder(Material material, int amount, short damage) {
		this.material = material;
		this.amount = amount;
		this.damage = damage;
		meta = Bukkit.getItemFactory().getItemMeta(material);
	}

	public void addLoreLine(String line) {
		lore.add(Chat.colorize(line));
	}

	public ItemStack build() {
		item = new ItemStack(material, amount, damage);
		meta.setDisplayName(Chat.colorize(name));
		meta.setLore(Chat.colorizeList(lore));
		item.setItemMeta(meta);
		for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
			item.addUnsafeEnchantment(entry.getKey(), entry.getValue());
		}
		return item;
	}

}
