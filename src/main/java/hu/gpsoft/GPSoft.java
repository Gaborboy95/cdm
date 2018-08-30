package hu.gpsoft;

//The author of this mod is Gaborboy95

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.core.Laptop;
import hu.gpsoft.apps.CheeseIDE;
import com.mrcrayfish.device.api.ApplicationManager;
import hu.gpsoft.blocks.tileentity.TileEntityAIO;
import hu.gpsoft.blocks.tileentity.TileEntityMonitor;
import hu.gpsoft.proxy.CommonProxy;
import hu.gpsoft.util.Reference;
import net.hdt.huskylib2.blocks.BlockColored;
import net.hdt.huskylib2.items.ItemColored;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static hu.gpsoft.init.ModBlocks.aios;

@Mod(
        modid = "gpsoft",
        name = "GPSoft inc.",
        version = "0.0.2",
        acceptedMinecraftVersions = "[1.12.2]",
        dependencies = "required-after:cdm@[0.4.1,)"
)

public class GPSoft
{
    @Mod.Instance
    public static GPSoft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    private void init(FMLInitializationEvent event) {
        final Application application = ApplicationManager.registerApplication(new ResourceLocation("gpsoft", "cheeseide"), CheeseIDE.class);

        GameRegistry.registerTileEntity(TileEntityMonitor.class, "gpsoft:aio_pc_block");

        ItemColors items = Minecraft.getMinecraft().getItemColors();
        BlockColors blocks = Minecraft.getMinecraft().getBlockColors();

        IItemColor handlerItems = (s, t) -> t == 0 ? ((ItemColored) s.getItem()).color.getColorValue() : 0xFFFFFF;
        items.registerItemColorHandler((stack, tintIndex) -> blocks.colorMultiplier(((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata()), null, null, tintIndex), aios);

        IBlockColor handlerBlocks = (s, w, p, t) -> t == 0 ? ((BlockColored) s.getBlock()).color.getColorValue() : 0xFFFFFF;
        blocks.registerBlockColorHandler(handlerBlocks, aios);
    }

    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }

}
