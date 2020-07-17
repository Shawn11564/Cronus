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
		skullMeta = (SkullMeta) getMeta();
	}

	public SkullBuilder(Material material, int amount) {
		super(material, amount);
		skullMeta = (SkullMeta) getMeta();
	}

	public SkullBuilder setOwner(UUID owner) {
		skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(owner));
		return this;
	}

	@Override
	public ItemStack build() {
		skullMeta.setLore(getLore());
		getEnchants().forEach((key, value) -> getItem().addUnsafeEnchantment(key, value));
		getItem().setItemMeta(skullMeta);
		return getItem();
	}
}
