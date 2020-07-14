package uk.kaidev.randomos;

import java.text.MessageFormat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandRankManager extends MenuRankManager implements CommandExecutor {
	public static String rankee;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("rankmanager")) {
			if(args[0].isEmpty()) {
				sender.sendMessage("§cYou must specify a valid player! Usage: /rankmanager [user]");
				return true;
			}
			if(sender instanceof ConsoleCommandSender) {
				sender.sendMessage(
						MessageFormat.format("Rank Manager is a player tool! Use /{0}.", MessageFormat.format(
								Globals.formatRole, "[username]", "[role]")));
				return true;
			}
			rankee = args[0];
			rankManager.open((Player) sender);
			return true;
		}
		return false;
	}
}
