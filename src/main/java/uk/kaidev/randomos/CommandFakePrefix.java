package uk.kaidev.randomos;

import java.text.MessageFormat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandFakePrefix implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("fakeprefix")) {
			String prefix = "";
			switch (args[0]) {
			case "owner":
				prefix += "&6&lOwner &r";
				break;
			case "operator":
				prefix += "&b&lOperator &r"; 
				break;
			case "admin":
				prefix += "&c&lAdmin &r";
				break;
			case "moderator":
				prefix += "&9&lModerator &r";
				break;
			case "watcher":
				prefix += "&e&lWatcher &r";
				break;
			case "god":
				prefix += "&dGod &r";
				break;
			case "plus":
				prefix += "&aPlus &r";
				break;
			case "default":
				prefix += "&7Default &r";
				break;
			default:
				sender.sendMessage("§cThat rank isn't correct.");
				return true;
			}
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format(Globals.formatRemovePrefix, args[1], Globals.priorityCodeFPX));
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format(Globals.formatSetPrefix, args[1], Globals.priorityCodeFPX, prefix));
			sender.sendMessage(MessageFormat.format("§bUser §f{0}§b now has their prefix set to {1}. §7§oCODE: {2}.", args[1], args[0], Globals.priorityCodeFPX));
			return true;
		}
		return false;
	}
}
