package uk.kaidev.randomos;

import java.io.IOException;
import java.text.MessageFormat;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenerPlayerLogin implements Listener {
	@EventHandler(priority = EventPriority.HIGH) // This needs to run correctly.
	public void onJoin(PlayerJoinEvent event) {
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		try {
			Bukkit.dispatchCommand(console, MessageFormat.format("defaultgamemode {0}", FileDefaultGamemode.readDefaultGamemode()));
		} catch (IOException e) {
			e.printStackTrace();
			console.sendMessage("§cDefault gamemode read failed!");
		}
		console.sendMessage("[Randomos] onLogin called.");
		Server server = Bukkit.getServer();
		GameMode defaultGamemode = server.getDefaultGameMode();
		HumanEntity player = event.getPlayer();
		player.setGameMode(defaultGamemode);
		String playGM = player.getGameMode().toString();
		console.sendMessage("[Randomos] §b" +  player.getName() + "§r set to §b" + playGM);
		player.sendMessage("§eRandomos framework loaded.");
	}
}
