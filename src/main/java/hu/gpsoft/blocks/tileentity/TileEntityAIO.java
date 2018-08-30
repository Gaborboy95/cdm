package hu.gpsoft.blocks.tileentity;

import com.mrcrayfish.device.MrCrayfishDeviceMod;
import com.mrcrayfish.device.tileentity.TileEntityLaptop;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityAIO extends TileEntity
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public void onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        if (tileEntity instanceof TileEntityAIO) {
            TileEntity AIO = tileEntity;
            if (!worldIn.isRemote) {
                playerIn.openGui(MrCrayfishDeviceMod.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
            }
        }
    }
}
