package com.matthewperiut.nukes.block;

import com.matthewperiut.nukes.Nukes;
import com.matthewperiut.nukes.entity.DiamondNukeEntity;
import com.matthewperiut.nukes.entity.GenericNukeEntity;

public class DiamondNuke extends GenericNuke
{
    public DiamondNuke(Settings settings)
    {
        super(settings, (world, x, y, z, livingEntity) -> {
            DiamondNukeEntity tntEntity;
            tntEntity = new DiamondNukeEntity(Nukes.DIAMOND_NUKE_ENTITY, world);
            GenericNukeEntity.update(tntEntity, world, x, y, z);
            return tntEntity;
        });
    }
}
