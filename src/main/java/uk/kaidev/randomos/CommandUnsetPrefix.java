package uk.kaidev.randomos;

import java.text.MessageFormat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandUnsetPrefix implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("unsetprefix")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format(Globals.formatRemovePrefix, args[0], Globals.priorityCodeFPX));
			sender.sendMessage("§bUser's fake prefix has been removed.");
			return true;
		}
		return false;
	}
}	
