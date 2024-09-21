package com.matthewperiut.nukes.entity;

import com.matthewperiut.nukes.Nukes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class NetheriteNukeEntity extends GenericNukeEntity {
    public NetheriteNukeEntity(EntityType<? extends NetheriteNukeEntity> entityType, World world)
    {
        super(entityType, world);
        this.setFuse(200);
    }

    public double getBodyY(double y, double heightScale)
    {
        return y + (double)this.getHeight() * heightScale;
    }

    @Override
    public void explode()
    {
        float f = 34.0F;
        float separator = 20;

        double blockX = this.getX() - separator/2;
        double blockY = this.getX() - separator/2;
        double blockZ = this.getX() - separator/2;

        for(int tx = 0; tx < 2; tx++)
        {
            for(int ty = 0; ty < 2; ty++)
            {
                float adjustment = -(separator/2) + separator*tx;
                float adjustment2 = -(separator/2) + separator*ty;
                this.world.createExplosion(this, this.getX()+adjustment, this.getBodyY(0.0625D), this.getZ()+adjustment2, f, World.ExplosionSourceType.TNT);
            }
        }
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), f, World.ExplosionSourceType.TNT);
    }
}
