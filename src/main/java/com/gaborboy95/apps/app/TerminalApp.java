package com.gaborboy95.apps.app;

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.component.TextField;
import net.minecraft.nbt.NBTTagCompound;
import org.luaj.vm2.*;
import org.luaj.vm2.lib.*;

public class TerminalApp extends Application
{
    public TextField textfield;

    @Override
    public void init() {
        this.setDefaultWidth(500);
        this.setDefaultHeight(250);
        textfield = new TextField(0,200,200);
        this.addComponent(textfield);
    }

    @Override
    public void load(NBTTagCompound tagCompound) {

    }


    @Override
    public void save(NBTTagCompound tagCompound) {

    }
}
