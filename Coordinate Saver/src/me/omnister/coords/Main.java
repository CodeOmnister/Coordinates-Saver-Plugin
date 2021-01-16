package me.omnister.coords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {

	}

	@Override
	public void onDisable() {

	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		File file = new File("coordinates.txt");
		
		if (label.equalsIgnoreCase("SaveCoords")) {
			
			
			
			Player player = (Player) sender;
			FileWriter fileWriter = null;
			
			try {
				fileWriter = new FileWriter(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			int coordName = 0;
			int coordX = 1;
			int coordY = 2;
			int coordZ = 3;
			
			/*
			 
			try {
				logCoords(sender, file, args[coordName], args[coordX], args[coordY], args[coordZ]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			*/
			
			
			try {
				fileWriter.append(args[coordName] + ": " + args[coordX] + ", " + args[coordY] + ", " + args[coordZ] + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			player.sendMessage(ChatColor.GREEN + "Coordinates Saved!");
			
			
			
			return true;
			
			
		}
		
		if (label.equalsIgnoreCase("SeeCoords")) {
			
			Player player = (Player) sender;
			
			Scanner scan = null;
			
			try {
				scan = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while (scan.hasNextLine()) {
				player.sendMessage(ChatColor.YELLOW + scan.nextLine());
			}
			
			return true;
			
		}
		
		return false;
	}
	
	/*
	 
	 
	public static void logCoords(CommandSender sender, File fName, String name, String xCoord, String yCoord, String zCoord) throws IOException {
		
		Player player = (Player) sender;
	
		FileWriter fileWriter = new FileWriter(fName);
		
		fileWriter.write(name + ": " + xCoord + ", " + yCoord + ", " + zCoord + "\n");
		
		fileWriter.close();
		
		player.sendMessage(ChatColor.GREEN + "Coordinates Saved!");
	}
	
	public static void seeCoords(CommandSender sender, File filename) throws IOException {
		
	}
	
	*/

	
}
