package com.matthewperiut.nukes.block;

import com.matthewperiut.nukes.Nukes;
import com.matthewperiut.nukes.entity.CoalNukeEntity;
import com.matthewperiut.nukes.entity.GenericNukeEntity;

public class CoalNuke extends GenericNuke
{
    public CoalNuke(Settings settings)
    {
        super(settings, (world, x, y, z, livingEntity) -> {
            CoalNukeEntity tntEntity;
            tntEntity = new CoalNukeEntity(Nukes.COAL_NUKE_ENTITY, world);
            GenericNukeEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
