package com.matthewperiut.nukes.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public class CoalNukeEntity extends GenericNukeEntity {
    public CoalNukeEntity(EntityType<? extends CoalNukeEntity> entityType, World world)
    {
        super(entityType, world);
        this.setFuse(100);
    }

    @Override
    public void explode()
    {
        float f = 8.0F;
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), f, World.ExplosionSourceType.TNT);
    }
}
