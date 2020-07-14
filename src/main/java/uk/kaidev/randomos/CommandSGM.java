package uk.kaidev.randomos;

import java.io.IOException;
import java.text.MessageFormat;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandSGM extends MenuSetGamemode implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("sgm")) {
			if (sender instanceof ConsoleCommandSender) {
				if (args[0].isEmpty()) {
				    sender.sendMessage("The set gamemode menu is a player tool! Use §b/sgm [mode]§r.");
				    return true;
				}
				String gamemode = args[0].toLowerCase();
				if((gamemode.equals("creative")
				| gamemode.equals("survival")
				| gamemode.equals("spectator")) == false) {
					sender.sendMessage("That gamemode isn't supported. Supported gamemodes: §bsurvival, creative, spectator§r.");
					return true;
				}
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format("defaultgamemode {0}", gamemode));
				for(World w : Bukkit.getServer().getWorlds()) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format(Globals.formatDefaultGamemode, gamemode, w.getName()));	
				}
				try {
					FileDefaultGamemode.writeDefaultGamemode(gamemode);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sender.sendMessage(MessageFormat.format("§bThe default gamemode has been successfully set to {0}.", gamemode));
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format(Globals.formatDiscordAnnounce, "#sgm-log", "CONSOLE", gamemode));
				return true;
			}
			else {
				setGamemode.open((Player) sender);
				return true;	
			}
		}
		return false;
	}
}
