package rocks.spud.server.disablehunger;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Provides a simple plugin for disabling hunger.
 * @author {@literal Johannes Donath <johannesd@torchmind.com>}
 */
public class DisableHungerPlugin extends JavaPlugin implements Listener {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onEnable () {
		super.onEnable ();

		this.getServer ().getPluginManager ().registerEvents (this, this);
	}

	/**
	 * Handles food level changes.
	 * @param event The event.
	 */
	@EventHandler (priority = EventPriority.HIGH)
	public void onFoodLevelChange (FoodLevelChangeEvent event) {
		if (event.getEntityType () != EntityType.PLAYER) return;
		event.setCancelled (true);
	}
}
