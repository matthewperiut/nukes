package com.matthewperiut.nukes;

import com.matthewperiut.nukes.block.*;
import com.matthewperiut.nukes.entity.*;
import com.matthewperiut.nukes.item.DiamondNukeItem;
import com.matthewperiut.nukes.item.NetheriteNukeItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Nukes implements ModInitializer {
	public static final String MODID = "nukes";

	public static final Logger LOGGER = LogManager.getLogger(MODID);



	public static final EntityType<CoalNukeEntity> COAL_NUKE_ENTITY = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(MODID, "coal_nuke"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, CoalNukeEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());
	public static final EntityType<IronNukeEntity> IRON_NUKE_ENTITY = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(MODID, "iron_nuke"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, IronNukeEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());
	public static final EntityType<GoldNukeEntity> GOLD_NUKE_ENTITY = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(MODID, "gold_nuke"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, GoldNukeEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());
	public static final EntityType<DiamondNukeEntity> DIAMOND_NUKE_ENTITY = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(MODID, "diamond_nuke"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, DiamondNukeEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());
	public static final EntityType<NetheriteNukeEntity> NETHERITE_NUKE_ENTITY = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(MODID, "netherite_nuke"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, NetheriteNukeEntity::new).dimensions(EntityDimensions.fixed(0.98f, 0.98f)).fireImmune().trackRangeBlocks(10).trackedUpdateRate(10).build());

	public static final Block COAL_NUKE_BLOCK = new CoalNuke(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));
	public static final Block IRON_NUKE_BLOCK = new IronNuke(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));
	public static final Block GOLD_NUKE_BLOCK = new GoldNuke(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));
	public static final Block DIAMOND_NUKE_BLOCK = new DiamondNuke(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));
	public static final Block NETHERITE_NUKE_BLOCK = new NetheriteNuke(FabricBlockSettings.of(Material.TNT).breakInstantly().sounds(BlockSoundGroup.GRASS));

	@Override
	public void onInitialize()
	{
		Registry.register(Registries.BLOCK, new Identifier(MODID, "coal_nuke"), COAL_NUKE_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(MODID, "iron_nuke"), IRON_NUKE_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(MODID, "gold_nuke"), GOLD_NUKE_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(MODID, "diamond_nuke"), DIAMOND_NUKE_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(MODID, "netherite_nuke"), NETHERITE_NUKE_BLOCK);

		Registry.register(Registries.ITEM, new Identifier(MODID, "coal_nuke"), new BlockItem(COAL_NUKE_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MODID, "iron_nuke"), new BlockItem(IRON_NUKE_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MODID, "gold_nuke"), new BlockItem(GOLD_NUKE_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MODID, "diamond_nuke"), new DiamondNukeItem(DIAMOND_NUKE_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MODID, "netherite_nuke"), new NetheriteNukeItem(NETHERITE_NUKE_BLOCK, new FabricItemSettings()));
	}
}
