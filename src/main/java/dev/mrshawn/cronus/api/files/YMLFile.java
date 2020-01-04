package dev.mrshawn.cronus.api.files;

import dev.mrshawn.cronus.API;
import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@Getter
public class YMLFile {

	private File file;
	private YamlConfiguration config;

	public YMLFile(String name, boolean resource) {
		file = new File(API.getPlugin().getDataFolder() + File.separator + name + ".yml");
		if (resource) {
			API.getPlugin().saveResource(name + ".yml", false);
		} else {
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (final IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		config = YamlConfiguration.loadConfiguration(file);
	}

	public void reload() {
		config = YamlConfiguration.loadConfiguration(file);
	}

	public void save() {
		try {
			config.save(file);
		} catch (final IOException ex) {
			ex.printStackTrace();
		}
	}

}
