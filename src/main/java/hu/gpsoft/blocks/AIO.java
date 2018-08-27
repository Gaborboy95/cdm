package hu.gpsoft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;

public class AIO extends BlockBase
{

    public AIO(String name, Material material)
    {
        super(name, material);

        this.setSoundType(SoundType.METAL);
        this.setHardness(0.5F);
        this.setResistance(15.0F);
        this.setLightLevel(1.0F);
        //this.setBlockUnbreakable();
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
}
