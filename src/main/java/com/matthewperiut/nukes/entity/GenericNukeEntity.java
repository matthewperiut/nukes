package com.matthewperiut.nukes.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class GenericNukeEntity extends TntEntity {
    private static final TrackedData<Integer> FUSE;

    private int fuseTimer;

    public GenericNukeEntity(EntityType<? extends GenericNukeEntity> entityType, World world) {
        super(entityType, world);
        this.fuseTimer = 80;
    }

    public static void update(GenericNukeEntity entity, World world, double x, double y, double z) {
        entity.updatePosition(x, y, z);
        final double d = world.random.nextDouble() * 6.2831854820251465;
        entity.setVelocity(-Math.sin(d) * 0.02, 0.20000000298023224, -Math.cos(d) * 0.02);
        entity.setFuse(entity.getFuse());
        entity.prevX = x;
        entity.prevY = y;
        entity.prevZ = z;
    }

    protected void initDataTracker() {
        this.dataTracker.startTracking((TrackedData) this.FUSE, (Object) 80); // 80 = 4*20 -> 4 seconds in ticks
    }

    public boolean collides() {
        return !this.isRemoved();
    }

    public void tick() {
        if (!this.hasNoGravity()) {
            this.setVelocity(this.getVelocity().add(0.0, -0.04, 0.0));
        }
        this.move(MovementType.SELF, this.getVelocity());
        this.setVelocity(this.getVelocity().multiply(0.98));
        if (this.onGround) {
            this.setVelocity(this.getVelocity().multiply(0.7, -0.5, 0.7));
        }
        --this.fuseTimer;
        if (this.fuseTimer <= 0)
        {
            if (!this.world.isClient)
            {
                this.explode();
            }
            this.discard();
        } else {
            this.updateWaterState();
            if (this.world.isClient) {
                this.world.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5, this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    public void explode() { // Don't call this on custom TNT's, unless it's meant to explode as vanilla TNT. Instead, override it.
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), 4, World.ExplosionSourceType.TNT);
    }

    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putShort("Fuse", (short)this.getFuse());
    }

    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.setFuse(nbt.getShort("Fuse"));
    }

    protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.15f;
    }

    public void onTrackedDataSet(TrackedData<?> data) {
        if (GenericNukeEntity.FUSE.equals(data)) {
            this.fuseTimer = this.getFuse();
        }
    }

    public int getFuse() {
        return (int) this.dataTracker.get((TrackedData) GenericNukeEntity.FUSE);
    }

    public void setFuse(final int fuse) {
        this.dataTracker.set((TrackedData) GenericNukeEntity.FUSE, (Object) fuse);
        this.fuseTimer = fuse;
    }

    public int getFuseTimer() {
        return this.fuseTimer;
    }

    static {
        FUSE = DataTracker.registerData(TntEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }
}
