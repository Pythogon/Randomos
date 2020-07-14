package uk.kaidev.randomos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandSetSuffix extends MenuSetSuffix implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("suffix")) {
			if (sender instanceof ConsoleCommandSender) { return true; }
			setSuffix.open((Player)sender);
			return true;			
		}
		return false;
	}
}
