package com.gaborboy95.apps.app;

import com.mrcrayfish.device.api.app.Application;
import dan200.computercraft.shared.common.ITerminal;
import net.minecraft.nbt.NBTTagCompound;

public class TerminalApp extends Application
{


    @Override
    public void init() {
        this.setDefaultWidth(500);
        this.setDefaultHeight(300);
        ITerminal terminal = new ITerminal() {
            @Override
            public int getTerminal() {
                return Integer.parseInt(null);
            }

            @Override
            public boolean isColour() {
                return true;
            }
        };

    }

    @Override
    public void load(NBTTagCompound tagCompound) {

    }


    @Override
    public void save(NBTTagCompound tagCompound) {

    }
}
