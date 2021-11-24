package com.matthewperiut.nukes.block;

import com.matthewperiut.nukes.entity.GenericNukeEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

@FunctionalInterface
public interface TntBuilder
{
    GenericNukeEntity create(World world, double p1, double p2, double p3, @Nullable LivingEntity livingEntity);
}