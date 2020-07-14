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
			try {
				if (args[0].equalsIgnoreCase("owner")) { prefix += "&6&lOwner &r"; } 
				else if (args[0].equalsIgnoreCase("operator")) { prefix += "&b&lOperator &r"; } 
				else if (args[0].equalsIgnoreCase("admin")) { prefix += "&c&lAdmin &r"; }
				else if (args[0].equalsIgnoreCase("moderator")) { prefix += "&9&lModerator &r"; }
				else if (args[0].equalsIgnoreCase("watcher")) { prefix += "&e&lWatcher &r"; }
				else if (args[0].equalsIgnoreCase("god")) { prefix += "&dGod &r"; }
				else if (args[0].equalsIgnoreCase("plus")) { prefix += "&aPlus &r"; }
				else if (args[0].equalsIgnoreCase("default")) { prefix += "&7Player &r"; }
				else { throw new NullPointerException(); }
				
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format(Globals.formatRemovePrefix, args[1], Globals.priorityCodeFPX));
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format(Globals.formatSetPrefix, args[1], Globals.priorityCodeFPX, prefix));
				sender.sendMessage(MessageFormat.format("§bUser §f{0}§b now has their prefix set to {1}. §7§oCODE: {2}.", args[1], args[0], Globals.priorityCodeFPX));
				return true;
			}
			catch (NullPointerException e) {
				sender.sendMessage("§cThat rank isn't correct.");
				return true;
			}
		}
		return false;
	}
}
