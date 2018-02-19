package com.gaborboy95.apps;

//The author of this mod is Gaborboy95

import com.gaborboy95.apps.app.TerminalApp;
import com.mrcrayfish.device.api.ApplicationManager;
import com.mrcrayfish.device.api.app.Application;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, acceptedMinecraftVersions = Reference.MC_VERSION, dependencies = Reference.DEPENDS)
public class CCTerminal
{
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        final Application terminalapp = ApplicationManager.registerApplication(new ResourceLocation(Reference.MOD_ID, "terminalapp"), TerminalApp.class);
    }

}
