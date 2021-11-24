package com.matthewperiut.nukes.block;

import com.matthewperiut.nukes.Nukes;
import com.matthewperiut.nukes.entity.GenericNukeEntity;
import com.matthewperiut.nukes.entity.GoldNukeEntity;
import com.matthewperiut.nukes.entity.IronNukeEntity;

public class GoldNuke extends GenericNuke
{
    public GoldNuke(Settings settings)
    {
        super(settings, (world, x, y, z, livingEntity) -> {
            GoldNukeEntity tntEntity;
            tntEntity = new GoldNukeEntity(Nukes.GOLD_NUKE_ENTITY, world);
            GenericNukeEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
