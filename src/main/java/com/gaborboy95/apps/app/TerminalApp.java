package com.gaborboy95.apps.app;

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.Dialog;
import com.mrcrayfish.device.api.app.Icons;
import com.mrcrayfish.device.api.app.component.Button;
import com.mrcrayfish.device.api.app.component.TextField;
import net.minecraft.nbt.NBTTagCompound;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class TerminalApp extends Application
{
    public TextField textfield;
    public Button btn;

    @Override
    public void init() {
        this.setDefaultWidth(500);
        this.setDefaultHeight(250);
        textfield = new TextField(0,148,345);
        btn = new Button(346,148, 16, 16,"", Icons.SEND);
        this.addComponent(textfield);
        this.addComponent(btn);

        btn.setClickListener(this::onClick);

    }

    @Override
    public void load(NBTTagCompound tagCompound) {

    }


    @Override
    public void save(NBTTagCompound tagCompound) {

    }

    private void onClick(int i, int i1, int i2)
    {
        if (i2 == 0)
        {
            String script = textfield.getText();
            if (script.length() > 0)
            {
                Globals lv = JsePlatform.standardGlobals();

                try
                {
                    LuaValue print = lv.load(script);
                }
                catch (LuaError error)
                {
                    this.openDialog(new Dialog.Message("Error! " + String.valueOf(error)));
                }
            }
            else
            {
                
            }
        }
    }
}
