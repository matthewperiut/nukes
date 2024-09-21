package com.matthewperiut.nukes.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class DiamondNukeEntity extends GenericNukeEntity {
    public DiamondNukeEntity(EntityType<? extends DiamondNukeEntity> entityType, World world)
    {
        super(entityType, world);
        this.setFuse(160);
    }

    @Override
    public void explode()
    {
        float f = 34.0F;
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), f, World.ExplosionSourceType.TNT);
    }
}
