package com.vislo.VisloBlock;

import net.minecraft.server.v1_7_R4.Block;
import net.minecraft.server.v1_7_R4.CreativeModeTab;
import net.minecraft.server.v1_7_R4.Material;

public class BlockOfRedSandStone extends Block
{
	public static final String[] a = { "default", "chiseled", "smooth" };

	@SuppressWarnings("unused")
	private static final String[] b = { "normal", "carved", "smooth" };

	public BlockOfRedSandStone()
	{
		super(Material.STONE);
		a(CreativeModeTab.b);
	}

	public int getDropData(int i)
	{
		return i;
	}
}