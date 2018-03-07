package com.gaborboy95.apps.app;

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.Dialog;
import com.mrcrayfish.device.api.app.Icons;
import com.mrcrayfish.device.api.app.Layout;
import com.mrcrayfish.device.api.app.component.Button;
import com.mrcrayfish.device.api.app.component.Label;
import com.mrcrayfish.device.api.app.component.TextArea;
import com.mrcrayfish.device.api.app.component.TextField;
import com.mrcrayfish.device.api.io.File;
import com.mrcrayfish.device.programs.system.layout.StandardLayout;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;

public class TerminalApp extends Application
{
    public Label intro;
    private TextField textfield;
    private TextArea cmdLine;
    private boolean isStartup = true;
    private StandardLayout layoutMain;
    String newFileName;

    private void onClickNewFile(int i, int i1, int i2)
    {
        Dialog dialog = new Dialog.Input();
        dialog.setTitle("Save name");
        this.openDialog(dialog);
        newFileName = null;

        cmdLine.setVisible(true);
        intro.setVisible(false);
    }

    @Override
    public void init() {
        this.layoutMain = new StandardLayout(TextFormatting.AQUA+"LUAIDE & CC Terminal", 362, 250, this, (Layout)null);
        this.layoutMain.setIcon(Icons.COMPUTER);
        this.setCurrentLayout(layoutMain);

        //New file
        Button buttonNF = new Button(130,2,Icons.NEW_FILE);
        buttonNF.setToolTip("New file", "Make a new file");
        this.layoutMain.addComponent(buttonNF);
        buttonNF.setClickListener(this::onClickNewFile);
        //Save file
        Button buttonSF = new Button(155,2,Icons.SAVE);
        buttonSF.setToolTip("Save file", "Save the current file");
        this.layoutMain.addComponent(buttonSF);
        buttonSF.setClickListener(this::onClickSaveFile);

        cmdLine = new TextArea(0,21,362,143);
        this.layoutMain.addComponent(cmdLine);
        cmdLine.setVisible(false);

        intro = new Label(TextFormatting.GREEN+"Welcome to LuaIDE & CC Terminal!" + TextFormatting.DARK_AQUA+" [Insert coin]",57,90);
        this.layoutMain.addComponent(intro);
        //textfield = new TextField(0,148,345);
        //cmdLine = new TextArea(0,15,362,131);
        //Button btn = new Button(346, 148, 16, 16, "", Icons.SEND);
        //this.addComponent(textfield);
        //this.addComponent(cmdLine);
        //cmdLine.setEditable(false);
        //cmdLine.setText("Welcome to ccLua IDE!, this mod is still in development, so don't expect\nthat this will be the best LuaIDE Ever...");
        //this.addComponent(btn);
        //btn.setToolTip("Send command", "Send the command to process it.");
        //btn.setClickListener(this::onClickProcess);
    }

    private void onClickSaveFile(int i, int i1, int i2)
    {
        NBTTagCompound data = new NBTTagCompound();
        data.setString("appSave", cmdLine.getText());
        File saveFile = new File(newFileName,this,data);
        Dialog saveD;
        saveD = new Dialog.SaveFile(this,saveFile);
    }

    @Override
    public void load(NBTTagCompound tagCompound) {

    }


    @Override
    public void save(NBTTagCompound tagCompound) {

    }

    /*private void onClickProcess(int i, int i1, int i2)
    {
        if (i2 == 0)
        {
            if (isStartup)
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
                    //this.openDialog(new Dialog.Message(TextFormatting.RED+error.toString()));
                    Dialog dialog = new Dialog.Message(TextFormatting.RED+error.toString());
                    dialog.setTitle("Error! (LUA)");
                    this.openDialog(dialog);
                }
            }
        }
    }*/
}
