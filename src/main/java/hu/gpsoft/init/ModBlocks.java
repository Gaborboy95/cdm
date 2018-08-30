package hu.gpsoft.init;

import hu.gpsoft.blocks.AIO;
import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static Block[] aios = new Block[16];

    static {
        for (EnumDyeColor color : EnumDyeColor.values())
        {
            aios[color.getMetadata()] = new AIO(color);
        }
    }
}
