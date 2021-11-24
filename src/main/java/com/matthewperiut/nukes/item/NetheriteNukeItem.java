package com.matthewperiut.nukes.item;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NetheriteNukeItem extends BlockItem
{
    public NetheriteNukeItem(Block block, Settings settings) {
        super(block, settings);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext)
    {
        // formatted red text
        tooltip.add( new TranslatableText("block.nukes.warning1").formatted(Formatting.RED) );
        tooltip.add( new TranslatableText("block.nukes.warning2").formatted(Formatting.RED) );
        tooltip.add( new TranslatableText("block.nukes.warning10").formatted(Formatting.RED) );
    }
}
