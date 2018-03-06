package com.gaborboy95.apps.app;

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.Dialog;
import com.mrcrayfish.device.api.app.Icons;
import com.mrcrayfish.device.api.app.component.Button;
import com.mrcrayfish.device.api.app.component.TextArea;
import com.mrcrayfish.device.api.app.component.TextField;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

public class TerminalApp extends Application
{
    public TextField textfield;
    public TextArea cmdLine;
    public Button btn;
    public boolean isStartup;

    @Override
    public void init() {
        this.setDefaultWidth(500);
        this.setDefaultHeight(250);
        textfield = new TextField(0,148,345);
        cmdLine = new TextArea(0,0,362,147);
        btn = new Button(346,148, 16, 16,"", Icons.SEND);
        this.addComponent(textfield);
        this.addComponent(cmdLine);
        cmdLine.setEditable(false);
        isStartup = true;
        cmdLine.setText("Welcome to ccLua IDE!, this mod is still in development, so don't expect\nthat this will be the best LuaIDE Ever...");
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
            if (isStartup == true)
            {
                cmdLine.setText("");
            }

            String script = textfield.getText();
            if (script.length() > 0)
            {
                Globals gl = JsePlatform.standardGlobals();

                try
                {
                    LuaValue lv = gl.load(script);

                    if (script == "")
                    {
                        cmdLine.setText(lv.toString());
                    }
                    else
                    {
                        cmdLine.setText(cmdLine.getText() + "\n" + lv.toString());
                    }
                }
                catch (LuaError error)
                {
                    this.openDialog(new Dialog.Message("Error!\n" + TextFormatting.RED+error.toString()));
                }
            }
        }
    }
}
