package uk.kaidev.randomos;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClearChat implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("clearchat")) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				for(int i = 0; i < 100; i++) {
					player.sendMessage("");
				}
			}
			return true;
		}
		return false;
	}
}
