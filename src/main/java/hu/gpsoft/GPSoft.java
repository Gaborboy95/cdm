package hu.gpsoft;

//The author of this mod is Gaborboy95

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.core.Laptop;
import hu.gpsoft.apps.CheeseIDE;
import com.mrcrayfish.device.api.ApplicationManager;
import hu.gpsoft.proxy.CommonProxy;
import hu.gpsoft.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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

    }

    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }

}
