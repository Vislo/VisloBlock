package com.vislo.VisloBlock;

import java.lang.reflect.Field;
import java.util.Map;

import net.minecraft.server.v1_7_R4.Block;
import net.minecraft.server.v1_7_R4.Blocks;
import net.minecraft.server.v1_7_R4.Item;
import net.minecraft.server.v1_7_R4.ItemBlock;
import net.minecraft.server.v1_7_R4.ItemMultiTexture;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

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
		addBlocks();
	}

	@SuppressWarnings("deprecation")
	private void addBlocks()
	{
		BlockOfSlime SlimeBlock = new BlockOfSlime();
		BlockStoned stone = new BlockStoned();
		Material slimeMaterial = addMaterial("slime", 165);
		Material redMaterial = addMaterial("red_sandstone", 179);

		BlockOfRedSandStone RedSandStoneBlock = new BlockOfRedSandStone();
		Block.REGISTRY.a(165, "slime", SlimeBlock);
		Block.REGISTRY.a(1, "stone", stone);
		Block.REGISTRY.a(179, "red_sandstone", RedSandStoneBlock);
		Item.REGISTRY.a(165, "slime", new ItemBlock(SlimeBlock));
		Item.REGISTRY.a(1, "stone",  new ItemMultiTexture(stone, stone,BlockStoned.a).b("stone"));
		Item.REGISTRY.a(179, "red_sandstone", new ItemMultiTexture(RedSandStoneBlock, RedSandStoneBlock,BlockOfRedSandStone.a).b("red_sandstone"));

		ShapedRecipe slimeBlock = new ShapedRecipe(new ItemStack(
				Material.getMaterial("slime"))).shape(
				new String[] { "###", "###", "###" }).setIngredient('#',
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
				name, new Class[] { Integer.TYPE }, new Object[] { id });
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