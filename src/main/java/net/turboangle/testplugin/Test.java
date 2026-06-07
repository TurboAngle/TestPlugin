package net.turboangle.testplugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Test implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack item = event.getItem();
            if (item != null) {
                if (item.getType() == Material.RECOVERY_COMPASS) {
                    TNTPrimed tnt = player.getWorld().spawn(player.getLocation(), TNTPrimed.class);
                    tnt.setFuseTicks(10);
                }
            }
        }
    }
}
