package com.matthewperiut.nukes;

import com.matthewperiut.nukes.render.GenericNukeRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class ClientNukes implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        EntityRendererRegistry.register(Nukes.COAL_NUKE_ENTITY, (context) -> new GenericNukeRenderer(context, Nukes.COAL_NUKE_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(Nukes.IRON_NUKE_ENTITY, (context) -> new GenericNukeRenderer(context, Nukes.IRON_NUKE_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(Nukes.GOLD_NUKE_ENTITY, (context) -> new GenericNukeRenderer(context, Nukes.GOLD_NUKE_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(Nukes.DIAMOND_NUKE_ENTITY, (context) -> new GenericNukeRenderer(context, Nukes.DIAMOND_NUKE_BLOCK.getDefaultState()));
        EntityRendererRegistry.register(Nukes.NETHERITE_NUKE_ENTITY, (context) -> new GenericNukeRenderer(context, Nukes.NETHERITE_NUKE_BLOCK.getDefaultState()));
    }
}