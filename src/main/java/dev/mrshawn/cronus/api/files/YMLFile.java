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
	private File file;
	private YamlConfiguration config;

	public YMLFile(String name, boolean resource) {
		this.name = name;
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

	public void reload(Plugin plugin) {
		YamlConfiguration newConfig = YamlConfiguration.loadConfiguration(file);
		InputStream defConfigStream = plugin.getResource(name + ".yml");
		if (defConfigStream != null) {
			newConfig.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
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
