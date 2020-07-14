package uk.kaidev.randomos;

import java.text.MessageFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;

public class MenuRankManager implements InventoryProvider {
	
	public static final SmartInventory rankManager = SmartInventory.builder()
			.id("uk.kaidev.Randomos.RankManager")
			.provider(new MenuRankManager())
			.size(1,9)
			.title("Rank Manager")
			.build();

	public void init(Player player, InventoryContents contents) {
		// Exit Meta
		ItemStack exitItem = new ItemStack(Material.BLACK_CONCRETE);
		ItemMeta exitItemMeta = exitItem.getItemMeta();
		exitItemMeta.setDisplayName(ChatColor.DARK_RED + "Exit");
		exitItem.setItemMeta(exitItemMeta);
			
		// Operator Meta
		ItemStack opItem = new ItemStack(Material.LIGHT_BLUE_CONCRETE);
		ItemMeta opItemMeta = opItem.getItemMeta();
		opItemMeta.setDisplayName(ChatColor.AQUA + "Operator");
		opItem.setItemMeta(opItemMeta);
		
		// Admin Meta
		ItemStack adminItem = new ItemStack(Material.RED_CONCRETE);
		ItemMeta adminItemMeta = adminItem.getItemMeta();
		adminItemMeta.setDisplayName(ChatColor.RED + "Admin");
		adminItem.setItemMeta(adminItemMeta);
		
		// Moderator Meta
		ItemStack modItem = new ItemStack(Material.BLUE_CONCRETE);
		ItemMeta modItemMeta = modItem.getItemMeta();
		modItemMeta.setDisplayName(ChatColor.BLUE + "Moderator");
		modItem.setItemMeta(modItemMeta);
		
		// Watcher Meta
		ItemStack watcherItem = new ItemStack(Material.YELLOW_CONCRETE);
		ItemMeta watcherItemMeta = watcherItem.getItemMeta();
		watcherItemMeta.setDisplayName(ChatColor.YELLOW + "Watcher");
		watcherItem.setItemMeta(watcherItemMeta);
		
		// God Meta
		ItemStack godItem = new ItemStack(Material.MAGENTA_CONCRETE);
		ItemMeta godItemMeta = godItem.getItemMeta();
		godItemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "God");
		godItem.setItemMeta(godItemMeta);
		
		// Plus Meta
		ItemStack plusItem = new ItemStack(Material.LIME_CONCRETE);
		ItemMeta plusItemMeta = plusItem.getItemMeta();
		plusItemMeta.setDisplayName(ChatColor.GREEN + "Plus");
		plusItem.setItemMeta(plusItemMeta);
		
		// Default Meta
		ItemStack defaultItem = new ItemStack(Material.LIGHT_GRAY_CONCRETE);
		ItemMeta defaultItemMeta = defaultItem.getItemMeta();
		defaultItemMeta.setDisplayName(ChatColor.GRAY + "Default");
		defaultItem.setItemMeta(defaultItemMeta);
		
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		
		// 100000000
		contents.set(0, 0, ClickableItem.of(exitItem, 
				e ->  player.closeInventory()));
		
		// 010000000
		contents.set(0, 1, ClickableItem.of(opItem,
				e -> Bukkit.dispatchCommand(console, MessageFormat.format(Globals.formatRole, CommandRankManager.rankee, "op"))));
		
		// 001000000
		contents.set(0, 2, ClickableItem.of(adminItem,
				e -> Bukkit.dispatchCommand(console, MessageFormat.format(Globals.formatRole, CommandRankManager.rankee, "admin"))));
		
		// 000100000
		contents.set(0, 3, ClickableItem.of(modItem,
				e -> Bukkit.dispatchCommand(console, MessageFormat.format(Globals.formatRole, CommandRankManager.rankee, "moderator"))));
		
		// 000010000
		contents.set(0, 4, ClickableItem.of(watcherItem,
				e -> Bukkit.dispatchCommand(console, MessageFormat.format(Globals.formatRole, CommandRankManager.rankee, "watcher"))));
		
		// 000001000
		contents.set(0, 5, ClickableItem.of(godItem,
				e -> Bukkit.dispatchCommand(console, MessageFormat.format(Globals.formatRole, CommandRankManager.rankee, "god"))));
		
		// 000000100
		contents.set(0, 6, ClickableItem.of(plusItem,
				e -> Bukkit.dispatchCommand(console, MessageFormat.format(Globals.formatRole, CommandRankManager.rankee, "plus"))));
		
		// 000000010
		contents.set(0, 7, ClickableItem.of(defaultItem,
				e -> Bukkit.dispatchCommand(console, MessageFormat.format(Globals.formatRole, CommandRankManager.rankee, "default"))));
		
		// 000000001
		contents.set(0, 8, ClickableItem.of(exitItem, 
				e ->  player.closeInventory()));
	}
	@Override
	public void update(Player player, InventoryContents contents) {}
}