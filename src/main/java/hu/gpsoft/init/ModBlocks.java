package hu.gpsoft.init;

import hu.gpsoft.blocks.AIO;
import hu.gpsoft.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block AIO_PC_BLOCK = new AIO("aio_pc_block", Material.ROCK);
}
