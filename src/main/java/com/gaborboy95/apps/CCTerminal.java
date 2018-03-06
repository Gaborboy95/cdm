package com.gaborboy95.apps;

//The author of this mod is Gaborboy95

import com.gaborboy95.apps.app.TerminalApp;
import com.mrcrayfish.device.api.ApplicationManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = "cctapp",
        name = "Computercraft terminal for cdm",
        version = "0.1.3",
        acceptedMinecraftVersions = "[1.12.2]",
        dependencies = "required-after:cdm@[0.3.0,)"
)

public class CCTerminal
{

    @Mod.EventHandler
    private void init(FMLInitializationEvent event) {
        ApplicationManager.registerApplication(new ResourceLocation("cctapp", "terminalapp"), TerminalApp.class);
    }

}
