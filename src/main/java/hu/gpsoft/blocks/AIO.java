package hu.gpsoft.blocks;

import hu.gpsoft.blocks.tileentity.TileEntityAIO;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class AIO extends BlockBase implements ITileEntityProvider
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

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityAIO();
    }
}
