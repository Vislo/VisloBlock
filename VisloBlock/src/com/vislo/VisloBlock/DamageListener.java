package com.vislo.VisloBlock;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener
{
	@EventHandler
	public void FallDamage(EntityDamageEvent event)
	{
		if ((event.getCause() == EntityDamageEvent.DamageCause.FALL)
				&& (event.getEntity().getLocation().subtract(0, 1, 0)
						.getBlock().getType() == Material.getMaterial("slime")))
			event.setCancelled(true);
	}
}
