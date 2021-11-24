package com.matthewperiut.nukes.block;

import com.matthewperiut.nukes.Nukes;
import com.matthewperiut.nukes.entity.DiamondNukeEntity;
import com.matthewperiut.nukes.entity.GenericNukeEntity;
import com.matthewperiut.nukes.entity.NetheriteNukeEntity;

public class NetheriteNuke extends GenericNuke
{
    public NetheriteNuke(Settings settings)
    {
        super(settings, (world, x, y, z, livingEntity) -> {
            NetheriteNukeEntity tntEntity;
            tntEntity = new NetheriteNukeEntity(Nukes.NETHERITE_NUKE_ENTITY, world);
            GenericNukeEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
