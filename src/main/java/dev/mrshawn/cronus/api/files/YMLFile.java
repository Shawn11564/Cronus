package dev.mrshawn.cronus.api.files;

import com.google.common.base.Charsets;
import dev.mrshawn.cronus.API;
import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Getter
public class YMLFile {

	private String name;
	private boolean resource;
	private File file;
	private YamlConfiguration config;

	public YMLFile(String name, boolean resource) {
		this.name = name;
		this.resource = resource;
		file = new File(API.getPlugin().getDataFolder() + File.separator + name + ".yml");
		if (resource && !file.exists()) {
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

	public void reload(Plugin plugin) {
		if (file.exists()) {
			YamlConfiguration newConfig = YamlConfiguration.loadConfiguration(file);
			InputStream defConfigStream = plugin.getResource(name + ".yml");
			if (defConfigStream != null) {
				newConfig.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
			}
		} else {
			if (resource) {
				plugin.saveResource(name + ".yml", false);
			} else {
				try {
					file.createNewFile();
				} catch (final IOException ex) {
					ex.printStackTrace();
				}
			}
			config = YamlConfiguration.loadConfiguration(file);
		}
	}

	public void save() {
		try {
			config.save(file);
		} catch (final IOException ex) {
			ex.printStackTrace();
		}
	}

}
