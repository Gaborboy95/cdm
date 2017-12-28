package com.gaborboy95.apps.app;

import com.mrcrayfish.device.api.app.Application;
import dan200.computercraft.ComputerCraft;
import dan200.computercraft.core.computer.Computer;
import net.minecraft.nbt.NBTTagCompound;

public class TerminalApp extends Application
{

    @Override
    public void init() {
        this.setDefaultWidth(500);
        this.setDefaultHeight(300);
    }

    @Override
    public void load(NBTTagCompound tagCompound) {

    }


    @Override
    public void save(NBTTagCompound tagCompound) {

    }
}
