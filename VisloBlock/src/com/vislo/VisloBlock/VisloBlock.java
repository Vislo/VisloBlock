package com.vislo.VisloBlock;

import java.lang.reflect.Field;
import java.util.Map;

import net.minecraft.server.v1_7_R4.Block;
import net.minecraft.server.v1_7_R4.Item;
import net.minecraft.server.v1_7_R4.ItemBlock;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class VisloBlock extends JavaPlugin
{
	@SuppressWarnings("deprecation")
	public void onEnable()
	{
		try
		{
			DynamicEnumType.loadReflection();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		BlockOfSlime SlimeBlock = new BlockOfSlime();
		BlockOfRedSandStone RedSandStoneBlock = new BlockOfRedSandStone();

		Material slimeMaterial = addMaterial("slime", 165);
		Material redMaterial = addMaterial("red_sandstone", 179);

		Block.REGISTRY.a(165, "slime", SlimeBlock);
		Item.REGISTRY.a(165, "slime", new ItemBlock(SlimeBlock));
		Block.REGISTRY.a(179, "red_sandstone", RedSandStoneBlock);
		Item.REGISTRY.a(179, "red_sandstone", new ItemBlock(RedSandStoneBlock));

		ShapedRecipe slimeBlock = new ShapedRecipe(new ItemStack(slimeMaterial))
				.shape(new String[] { "###", "###", "###" }).setIngredient('#',
						Material.SLIME_BALL);
		Bukkit.getServer().addRecipe(slimeBlock);
		ShapelessRecipe deslimeBlock = new ShapelessRecipe(new ItemStack(
				Material.SLIME_BALL, 9));
		deslimeBlock.addIngredient(slimeMaterial);
		Bukkit.getServer().addRecipe(deslimeBlock);

		ShapedRecipe redSandStone = new ShapedRecipe(new ItemStack(redMaterial))
				.shape(new String[] { "   ", "## ", "## " }).setIngredient('#',
						Material.SAND, 1);
		Bukkit.getServer().addRecipe(redSandStone);
	}

	@SuppressWarnings("unchecked")
	public static Material addMaterial(String name, int id)
	{
		Material material = (Material) DynamicEnumType.addEnum(Material.class,
				name, new Class[] { Integer.TYPE },
				new Object[] { Integer.valueOf(id) });
		try
		{
			Field field = Material.class.getDeclaredField("BY_NAME");
			field.setAccessible(true);
			Object object = field.get(null);

			Map<String, Material> BY_NAME = (Map<String, Material>) object;
			BY_NAME.put(name, material);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Field field = Material.class.getDeclaredField("byId");
			field.setAccessible(true);
			Object object = field.get(null);
			Material[] byId = (Material[]) object;

			byId[id] = material;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return material;
	}
}