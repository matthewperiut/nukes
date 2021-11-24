package com.matthewperiut.nukes.block;

import com.matthewperiut.nukes.Nukes;
import com.matthewperiut.nukes.entity.CoalNukeEntity;
import com.matthewperiut.nukes.entity.GenericNukeEntity;
import com.matthewperiut.nukes.entity.IronNukeEntity;

public class IronNuke extends GenericNuke
{
    public IronNuke(Settings settings)
    {
        super(settings, (world, x, y, z, livingEntity) -> {
            IronNukeEntity tntEntity;
            tntEntity = new IronNukeEntity(Nukes.IRON_NUKE_ENTITY, world);
            GenericNukeEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
