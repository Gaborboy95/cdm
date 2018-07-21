package hu.gpsoft.apps;

//The author of this mod is Gaborboy95

import com.mrcrayfish.device.api.app.Application;
import hu.gpsoft.apps.app.CheeseIDE;
import com.mrcrayfish.device.api.ApplicationManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = "gabsapps",
        name = "Gab's Apps For CDM",
        version = "0.0.2",
        acceptedMinecraftVersions = "[1.12.2]",
        dependencies = "required-after:cdm@[0.4.1,)"
)

public class GabsApps
{

    @Mod.EventHandler
    private void init(FMLInitializationEvent event) {
        final Application application = ApplicationManager.registerApplication(new ResourceLocation("gabsapps", "cheeseide"), CheeseIDE.class);
    }

}
