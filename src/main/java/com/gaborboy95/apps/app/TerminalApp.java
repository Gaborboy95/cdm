package com.gaborboy95.apps.app;

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.Icons;
import com.mrcrayfish.device.api.app.component.Button;
import com.mrcrayfish.device.api.app.component.TextField;
import net.minecraft.nbt.NBTTagCompound;
import org.luaj.vm2.*;
import org.luaj.vm2.lib.*;
import org.luaj.vm2.lib.jse.JsePlatform;

public class TerminalApp extends Application
{
    public TextField textfield;
    public Button btn;

    @Override
    public void init() {
        this.setDefaultWidth(500);
        this.setDefaultHeight(250);
        textfield = new TextField(0,148,340);
        btn = new Button(345,148,"", Icons.SEND);
        this.addComponent(textfield);

        //String script = textfield.getText();
        //LuaValue lv = JsePlatform.standardGlobals();
        //lv.get("dofile").call( LuaValue.valueOf(script) );


    }

    @Override
    public void load(NBTTagCompound tagCompound) {

    }


    @Override
    public void save(NBTTagCompound tagCompound) {

    }
}
