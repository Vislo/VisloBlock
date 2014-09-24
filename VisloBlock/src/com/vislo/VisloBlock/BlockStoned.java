package com.vislo.VisloBlock;

import java.util.Random;

import net.minecraft.server.v1_7_R4.Block;
import net.minecraft.server.v1_7_R4.Blocks;
import net.minecraft.server.v1_7_R4.CreativeModeTab;
import net.minecraft.server.v1_7_R4.Item;
import net.minecraft.server.v1_7_R4.Material;

public class BlockStoned extends Block
{
	public static final String[] a = { "default", "andesite" , "smooth_andesite", "diorite", "smooth_diorite","granite","smooth_granite"   };

	protected BlockStoned()
	{
		super(Material.STONE);
		a(CreativeModeTab.b);
	}

	public Item getDropType(int paramInt1, Random paramRandom, int paramInt2)
	{
		return Item.getItemOf(Blocks.COBBLESTONE);
	}
}