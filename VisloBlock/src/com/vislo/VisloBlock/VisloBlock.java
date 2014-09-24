package com.vislo.VisloBlock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.vislo.VisloBlock.Listeners.DamageListener;
import com.vislo.VisloBlock.Utils.DynamicEnumType;

public class VisloBlock extends JavaPlugin
{
	public static VisloBlock plugin;
	public void onEnable()
	{
		plugin = this;
		try
		{
			DynamicEnumType.loadReflection();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
		InjectorManager.injectBlocks();
	}

}