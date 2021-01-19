package dev.mrshawn.cronus.api.files;

import com.google.common.base.Charsets;
import dev.mrshawn.cronus.API;
import dev.mrshawn.cronus.api.utils.Chat;
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

	public YMLFile(File file, boolean isResource) {
		this.file = file;
		this.resource = isResource;
		if (isResource && !file.exists()) {
			API.getPlugin().saveResource(file.getName() + ".yml", false);
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

	public YMLFile(String fileName, boolean isResource) {
		this.name = fileName;
		this.resource = isResource;
		file = new File(API.getPlugin().getDataFolder() + File.separator + fileName + ".yml");
		if (isResource && !file.exists()) {
			API.getPlugin().saveResource(fileName + ".yml", false);
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

	public YMLFile(String directory, String fileName, boolean isResource) {
		this.name = fileName;
		this.resource = isResource;

		File dir = new File(API.getPlugin().getDataFolder() + File.separator + directory);

		if (!dir.exists()) {
			dir.mkdir();
		}

		file = new File(API.getPlugin().getDataFolder() + File.separator + directory + File.separator + fileName + ".yml");

		if (isResource && !file.exists()) {
			API.getPlugin().saveResource(fileName + ".yml", false);
			try {
				File resource = new File(API.getPlugin().getDataFolder() + File.separator + fileName + ".yml");
				if (resource.renameTo(new File(API.getPlugin().getDataFolder() + File.separator + directory + File.separator + fileName + ".yml"))) {
					resource.delete();
					file = new File(API.getPlugin().getDataFolder() + File.separator + directory + File.separator + fileName + ".yml");
				}
			} catch (Exception e) {
				Chat.log("&4Unable to relocate: " + fileName + ".yml" + " to new location.");
				e.printStackTrace();
			}
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
