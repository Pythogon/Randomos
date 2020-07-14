package uk.kaidev.randomos;

import java.text.MessageFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;

public class MenuSetSuffix implements InventoryProvider {
	
	public void setSuffix(Player player, String suffix) {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
				MessageFormat.format(Globals.formatRemoveSuffix, player.getName(), Globals.priorityCodeFPX));
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
				MessageFormat.format(Globals.formatSetSuffix, player.getName(), Globals.priorityCodeFPX, suffix));
	}
	
	public static final SmartInventory setSuffix = SmartInventory.builder()
			.id("uk.kaidev.Randomos.SetSuffix")
			.provider(new MenuSetSuffix())
			.size(6,9)
			.title("Suffix Menu")
			.build();
	public void init(Player player, InventoryContents contents) {
		// Exit Meta
		ItemStack exitItem = new ItemStack(Material.BLACK_CONCRETE);
		ItemMeta exitItemMeta = exitItem.getItemMeta();
		exitItemMeta.setDisplayName(ChatColor.DARK_RED + "Exit");
		exitItem.setItemMeta(exitItemMeta);
		
		// Remove Suffix Meta
		ItemStack removeItem = new ItemStack(Material.MILK_BUCKET);
		ItemMeta removeItemMeta = removeItem.getItemMeta();
		removeItemMeta.setDisplayName("Remove Suffix");
		removeItem.setItemMeta(removeItemMeta);
		
		// The One Meta
		ItemStack theOneItem = new ItemStack(Material.PAPER);
		ItemMeta theOneItemMeta = theOneItem.getItemMeta();
		theOneItemMeta.setDisplayName("§e§othe One");
		theOneItem.setItemMeta(theOneItemMeta);
		
		// The Weak Meta
		ItemStack theWeakItem = new ItemStack(Material.PAPER);
		ItemMeta theWeakItemMeta = theWeakItem.getItemMeta();
		theWeakItemMeta.setDisplayName("§7§othe Weak");
		theWeakItem.setItemMeta(theWeakItemMeta);
		
		// The Gifted Meta
		ItemStack theGiftedItem = new ItemStack(Material.PAPER);
		ItemMeta theGiftedItemMeta = theGiftedItem.getItemMeta();
		theGiftedItemMeta.setDisplayName("§6§othe Gifted");
		theGiftedItem.setItemMeta(theGiftedItemMeta);
		
		contents.set(5, 0, ClickableItem.of(exitItem,
				e -> player.closeInventory()));
		
		contents.set(5, 8, ClickableItem.of(removeItem,
				e -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), MessageFormat.format(
						Globals.formatRemoveSuffix, player.getName(), Globals.priorityCodeFPX))));
		
		contents.set(0, 0, ClickableItem.of(theOneItem,
				e -> setSuffix(player, " §e§othe One")));
		
		contents.set(0, 1, ClickableItem.of(theWeakItem,
				e -> setSuffix(player, " §7§othe Weak")));
		
		contents.set(0, 2, ClickableItem.of(theGiftedItem,
				e -> setSuffix(player, " §e§othe Gifted")));

	}
	@Override
	public void update(Player player, InventoryContents contents) {}
}
