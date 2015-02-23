/*
 * Copyright 2015 Johannes Donath <johannesd@torchmind.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
