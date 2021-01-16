package me.omnister.coordsaver;

import java.util.Hashtable;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	public static Hashtable<String, String> coordLocs = new Hashtable<String, String>();
	
	@Override
	public void onEnable() {
		this.getConfig();
	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("SaveCoords")) {
			
			Player player = (Player) sender;
			
			
			if (args.length == 4) {
				this.getConfig().getConfigurationSection("coords").set(args[0], args[1] + ", " + args[2] + ", " + args[3]);
				player.sendMessage(ChatColor.GREEN + "Coordinates Saved!");
			} else if (args.length == 1) {
				this.getConfig().getConfigurationSection("coords").set(args[0], Math.round(player.getLocation().getX()) + ", " + Math.round(player.getLocation().getY()) + ", " + Math.round(player.getLocation().getZ()));
				player.sendMessage(ChatColor.GREEN + "Coordinates Saved!");
			} else {
				player.sendMessage(ChatColor.RED + "Enter Valid Arguments!");
			}
			
			
			this.saveConfig();
			return true;
		}
		
		if (label.equalsIgnoreCase("SeeCoords")) {
			
			Player player = (Player) sender;
			
			if (args.length == 0) {
				this.getConfig().getConfigurationSection("coords").getKeys(false).forEach(key -> {
					player.sendMessage(ChatColor.YELLOW + key + ": " + this.getConfig().getString("coords." + key));
				});
			} else if (args.length == 1) {
				this.getConfig().getConfigurationSection("coords").getKeys(false).forEach(key -> {
					if (key == args[0]) {
						player.sendMessage(ChatColor.YELLOW + key + ": " + this.getConfig().getString("coords." + key));
					}
				});
			}
			
			return true;
		}
		
		if (label.equalsIgnoreCase("RemoveCoords")) {
			
			Player player = (Player) sender;
			
			if (args.length == 1) {
				this.getConfig().getConfigurationSection("coords").getKeys(false).forEach(key -> {
					
					String path = "coords." + key;
					
					if (key.equalsIgnoreCase(args[0])) {
						this.getConfig().set(path, null);
						player.sendMessage(ChatColor.GOLD + "Entry Removed!");
					}
				});
				
				return true;
			}
			
			player.sendMessage(ChatColor.RED + "Enter Valid Arguments!");
			return true;
			
			
			
		}
		
		
		
		return false;
	}
	
	
}
