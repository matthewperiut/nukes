package com.matthewperiut.nukes.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class GoldNukeEntity extends GenericNukeEntity {
    public GoldNukeEntity(EntityType<? extends GoldNukeEntity> entityType, World world)
    {
        super(entityType, world);
        this.setFuse(140);
    }

    @Override
    public void explode()
    {
        float f = 21.0F;
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), f, Explosion.DestructionType.BREAK);
    }
}
