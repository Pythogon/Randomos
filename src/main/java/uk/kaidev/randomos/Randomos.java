package uk.kaidev.randomos;

import java.io.File;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.base.Stopwatch;

public final class Randomos extends JavaPlugin {
	public static File folder;
	@Override
	public void onEnable() {
		Stopwatch stopwatch = Stopwatch.createStarted();
		// Default gamemode fixer
		folder = getDataFolder();
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		
		console.sendMessage("Randomos load -§a START");
		getServer().getPluginManager().registerEvents(new ListenerPlayerLogin(), this);
		console.sendMessage("PLL §aLOAD");
		/*
		 *  Command loader  * 
		 */
		// Admin loader
		this.getCommand("clearchat").setExecutor(new CommandClearChat());
		this.getCommand("sgm").setExecutor(new CommandSGM());
		this.getCommand("rankmanager").setExecutor(new CommandRankManager());
		console.sendMessage("Admin §aLOAD");
		// Eco loader
		this.getCommand("daily").setExecutor(new CommandDaily());
		console.sendMessage("Eco §aLOAD");
		// Prefix loader 
		this.getCommand("fakeprefix").setExecutor(new CommandFakePrefix());
		this.getCommand("suffix").setExecutor(new CommandSetSuffix());
		this.getCommand("unsetprefix").setExecutor(new CommandUnsetPrefix());
		console.sendMessage(MessageFormat.format("Prefix Tools §aLOAD§r Priority code: §b{0}§r.", Globals.priorityCodeFPX));	
		// Loading complete. 
		stopwatch.stop();
		long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		getLogger().info(MessageFormat.format("Randomos load - §aCOMPLETE§r - Time elapsed: {0}.", (millis + "ms")));
		// Et c'est fini ! C'était simple, je suppose :D
	}
	@Override
	public void onDisable() {
		getLogger().info("Randomos unload");
	}
}