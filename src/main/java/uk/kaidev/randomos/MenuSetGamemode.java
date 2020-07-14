package uk.kaidev.randomos;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;

public class MenuSetGamemode implements InventoryProvider {
	
	public void gamemodeSet(Player player, String gamemode) {
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
		player.sendMessage(MessageFormat.format("§bThe default gamemode has been successfully set to {0}.", gamemode));
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format(Globals.formatDiscordAnnounce, "#sgm-log", player.getName(), gamemode));
	}
	
	public static final SmartInventory setGamemode = SmartInventory.builder()
			.id("uk.kaidev.Randomos.SetGamemode")
			.provider(new MenuSetGamemode())
			.size(1,9)
			.title("Gamemode Manager")
			.build();
	
	public void init(Player player, InventoryContents contents) {	
		// Exit Meta
		ItemStack exitItem = new ItemStack(Material.BARRIER);
		ItemMeta exitItemMeta = exitItem.getItemMeta();
		exitItemMeta.setDisplayName(ChatColor.DARK_RED + "Exit");
		exitItem.setItemMeta(exitItemMeta);
		
		// Survival Meta
		ItemStack survivalItem = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta survivalItemMeta = survivalItem.getItemMeta();
		survivalItemMeta.setDisplayName(ChatColor.GREEN + "Survival");
		survivalItem.setItemMeta(survivalItemMeta);
		
		// Creative Meta
		ItemStack creativeItem = new ItemStack(Material.GRASS_BLOCK);
		ItemMeta creativeItemMeta = creativeItem.getItemMeta();
		creativeItemMeta.setDisplayName(ChatColor.GOLD + "Creative");
		creativeItem.setItemMeta(creativeItemMeta);
		
		// Spectator Meta
		ItemStack spectatorItem = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta spectatorItemMeta = (SkullMeta) spectatorItem.getItemMeta();
		OfflinePlayer targetSkin = Bukkit.getOfflinePlayer(UUID.fromString("73721ba2-7d3a-46a8-82f5-a93e94265a6c"));
		spectatorItemMeta.setOwningPlayer(targetSkin);
		spectatorItemMeta.setDisplayName(ChatColor.AQUA + "Spectator");
		spectatorItem.setItemMeta(spectatorItemMeta);
		
		// 100000000
		contents.set(0, 0, ClickableItem.of(exitItem, e -> setGamemode.close(player)));
		
		// 000100000
		contents.set(0, 3, ClickableItem.of(survivalItem, e -> gamemodeSet(player, "survival")));
		
		//000010000
		contents.set(0, 4, ClickableItem.of(creativeItem, e -> gamemodeSet(player, "creative")));
		
		//000001000
		contents.set(0, 5, ClickableItem.of(spectatorItem, e -> gamemodeSet(player, "spectator")));
		
		// 000000001
		contents.set(0, 8, ClickableItem.of(exitItem, e -> setGamemode.close(player)));
	}

	@Override
	public void update(Player player, InventoryContents contents) {}
}
