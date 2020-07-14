package uk.kaidev.randomos;
import java.text.MessageFormat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandDaily implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("daily")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format(Globals.formatDaily, sender.getName(), "1000"));
			sender.sendMessage("§bYour daily balance has been recieved.");
			return true;
		}
		return false;
	}
}
