package com.vislo.VisloBlock;

import net.minecraft.server.v1_7_R4.Block;
import net.minecraft.server.v1_7_R4.Item;
import net.minecraft.server.v1_7_R4.ItemBlock;
import net.minecraft.server.v1_7_R4.ItemMultiTexture;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

import com.vislo.VisloBlock.Blocks.BlockOfRedSandStone;
import com.vislo.VisloBlock.Blocks.BlockOfSlime;
import com.vislo.VisloBlock.Blocks.BlockOfStone;
import com.vislo.VisloBlock.Utils.DynamicEnumType;

public class InjectorManager
{
	public static void injectBlocks()
	{
		//Blocks
		BlockOfSlime SlimeBlock = new BlockOfSlime();
		BlockOfStone stone = new BlockOfStone();
		BlockOfRedSandStone RedSandStoneBlock = new BlockOfRedSandStone();
		//Materials
		DynamicEnumType.addMaterial("slime", 165);
		DynamicEnumType.addMaterial("red_sandstone", 179);
		//Register the blocks
		Block.REGISTRY.a(165, "slime", SlimeBlock);
		Block.REGISTRY.a(1, "stone", stone);
		Block.REGISTRY.a(179, "red_sandstone", RedSandStoneBlock);
		Item.REGISTRY.a(165, "slime", new ItemBlock(SlimeBlock));
		//Register the items.
		Item.REGISTRY.a(1, "stone",  new ItemMultiTexture(stone, stone,BlockOfStone.a).b("stone"));
		Item.REGISTRY.a(179, "red_sandstone", new ItemMultiTexture(RedSandStoneBlock, RedSandStoneBlock,BlockOfRedSandStone.a).b("red_sandstone"));
		//Making the recipes
		injectRecipes();
	}
	@SuppressWarnings("deprecation")
	private static void injectRecipes()
	{
		ShapedRecipe slimeBlock = new ShapedRecipe(new ItemStack(
				Material.getMaterial("slime"))).shape(
				new String[] { "###", "###", "###" }).setIngredient('#',
				Material.SLIME_BALL);
		Bukkit.getServer().addRecipe(slimeBlock);
		ShapelessRecipe deslimeBlock = new ShapelessRecipe(new ItemStack(
				Material.SLIME_BALL, 9));
		deslimeBlock.addIngredient(Material.getMaterial("slime"));
		Bukkit.getServer().addRecipe(deslimeBlock);

		ShapedRecipe redSandStone = new ShapedRecipe(new ItemStack(Material.getMaterial("red_sandstone")))
				.shape(new String[] { "   ", "## ", "## " }).setIngredient('#',
						Material.SAND, 1);
		Bukkit.getServer().addRecipe(redSandStone);
		
	}

}
