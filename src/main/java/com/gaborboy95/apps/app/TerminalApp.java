package com.gaborboy95.apps.app;

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.component.Label;
import com.mrcrayfish.device.api.app.component.TextArea;
import net.minecraft.nbt.NBTTagCompound;

public class TerminalApp extends Application
{
    private Label WIP;
    private TextArea textWIP;

    @Override
    public void init() {
        WIP = new Label("CC Lua terminal app WIP!", 5,5);
        this.addComponent(WIP);
        textWIP = new TextArea(5,15,100,100);
        this.addComponent(textWIP);
    }

    @Override
    public void load(NBTTagCompound tagCompound) {

    }


    @Override
    public void save(NBTTagCompound tagCompound) {

    }
}
