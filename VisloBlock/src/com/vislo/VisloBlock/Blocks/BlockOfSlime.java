package com.vislo.VisloBlock.Blocks;

import net.minecraft.server.v1_7_R4.BlockHalfTransparent;
import net.minecraft.server.v1_7_R4.CreativeModeTab;
import net.minecraft.server.v1_7_R4.Entity;
import net.minecraft.server.v1_7_R4.Material;
import net.minecraft.server.v1_7_R4.StepSound;
import net.minecraft.server.v1_7_R4.World;

public class BlockOfSlime extends BlockHalfTransparent
{
  public BlockOfSlime()
  {
    super("slime", Material.CACTUS, false);
    a(CreativeModeTab.c);
    this.frictionFactor = 0.8F;
    this.stepSound = new StepSound("slime", 1.0F, 1.0F);
  }

  public void a(World paramaqu, int x, int y, int z, Entity paramwv, float paramFloat)
  {
    if (paramwv.isSneaking())
      super.a(paramaqu, x, y, z, paramwv, paramFloat);
  }

  public void a(World paramaqu, int x, int y, int z, Entity paramwv)
  {
    if ((Math.abs(paramwv.motY) < 0.1D) && (!paramwv.isSneaking()))
    {
      double d = 0.4D + Math.abs(paramwv.motY) * 0.2D;
      paramwv.motX *= d;
      paramwv.motZ *= d;
    }
    super.a(paramaqu, x, y, z, paramwv);
  }
}