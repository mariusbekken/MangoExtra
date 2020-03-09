package no.tinncraft.build.handlers;

import java.io.File;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import no.tinncraft.build.Main;

public class userDataHandler implements Listener {
	
	@SuppressWarnings("unused")
	private Main instance;
	public userDataHandler(Main instance) {
		this.instance = instance;
	}
 
	public UUID uuid;
	public File userFile;
	public FileConfiguration userConfig;
	
	public userDataHandler(UUID uuid) {
		this.uuid = uuid;
		
		userFile = new File("plugins/Mango/userdata", uuid + ".yml");
		
		userConfig = YamlConfiguration.loadConfiguration(userFile);
	}
	
	public void createUser(final Player player) {
		if(!(userFile.exists())) {
			try {
				YamlConfiguration userConfig = YamlConfiguration.loadConfiguration(userFile);
				
				userConfig.set("User.Name", player.getName());
				userConfig.set("User.UUID", player.getUniqueId().toString());
				userConfig.set("User.Group", "Spiller");
				userConfig.set("User.Balance", 0);
				
				userConfig.save(userFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public FileConfiguration getUserFile() {
		return userConfig;
	}
	
	public void saveUserFile() {
		try {
			getUserFile().save(userFile);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		userDataHandler user = new userDataHandler(e.getPlayer().getUniqueId());
		user.createUser(e.getPlayer());
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {

	}
}
