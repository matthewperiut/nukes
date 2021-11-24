package com.matthewperiut.nukes.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class IronNukeEntity extends GenericNukeEntity {
    public IronNukeEntity(EntityType<? extends IronNukeEntity> entityType, World world)
    {
        super(entityType, world);
        this.setFuse(120);
    }

    @Override
    public void explode()
    {
        float f = 13.0F;
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), f, Explosion.DestructionType.BREAK);
    }
}
