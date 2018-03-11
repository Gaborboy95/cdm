package com.gaborboy95.apps.app;

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.Dialog;
import com.mrcrayfish.device.api.app.Icons;
import com.mrcrayfish.device.api.app.Layout;
import com.mrcrayfish.device.api.app.component.Button;
import com.mrcrayfish.device.api.app.component.Label;
import com.mrcrayfish.device.api.app.component.TextArea;
import com.mrcrayfish.device.api.io.File;
import com.mrcrayfish.device.programs.system.layout.StandardLayout;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.util.Arrays;

public class TerminalApp extends Application
{
    public Label intro;
    public Label successL;
    private TextArea scriptLine;
    private TextArea cmdLine;
    private StandardLayout layoutMain;
    String newFileName;

    String[] colors1 =
            {
                    "if", "else", "elseif", "for", "do", "while", "end"
            };

    private TextFormatting getColor(String input)
    {
        if (Arrays.asList(colors1).contains(input))
        {
            return TextFormatting.DARK_AQUA;
        }
        return null;
    }

    private void onClickNewFile(int i, int i1, int i2)
    {
        Dialog.Input dialogI = new Dialog.Input();
        dialogI.setResponseHandler((success, string) ->
        {
            if (success)
            {
                newFileName = string;
                return true;
            }
            return false;
        });
        openDialog(dialogI);

        cmdLine.setVisible(true);
        cmdLine.setText("");
        intro.setVisible(false);
    }
    private void onClickOpenFile(int i, int i1, int i2)

    {
        Dialog.OpenFile dialog = new Dialog.OpenFile(this);
        dialog.setResponseHandler((success, file) -> {
            if (success) {
                cmdLine.setVisible(true);
                intro.setVisible(false);
                cmdLine.setText(file.getData().getString("appSave"));
                return true;
            }
            return false;
        });
        openDialog(dialog);
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
        Button buttonSF = new Button(150,2,Icons.SAVE);
        buttonSF.setToolTip("Save file", "Save the current file");
        this.layoutMain.addComponent(buttonSF);
        buttonSF.setClickListener(this::onClickSaveFile);
        //Open file
        Button buttonOF = new Button(170,2, Icons.BOOK_OPEN);
        buttonOF.setToolTip("Open file", "Open a saved file");
        this.layoutMain.addComponent(buttonOF);
        buttonOF.setClickListener(this::onClickOpenFile);
        //Run script
        Button buttonRS = new Button(190, 2, Icons.ARROW_RIGHT);
        buttonRS.setToolTip("Run script", "Run the script");
        this.layoutMain.addComponent(buttonRS);
        buttonRS.setClickListener(this::onClickRunScript);

        cmdLine = new TextArea(0,21,362,143);
        this.layoutMain.addComponent(cmdLine);
        cmdLine.setVisible(false);

        intro = new Label(TextFormatting.GREEN+"Welcome to LuaIDE & CC Terminal!" + TextFormatting.DARK_AQUA+" [Insert coin]",57,90);
        this.layoutMain.addComponent(intro);

        successL = new Label(TextFormatting.GREEN+"Successfully saved file!", 220,4);
        this.layoutMain.addComponent(successL);
        successL.setVisible(false);

        scriptLine = new TextArea(0,21,362,143);
        this.layoutMain.addComponent(scriptLine);
        scriptLine.setVisible(false);
    }

    private void onClickRunScript(int i, int i1, int i2)
    {
        String script = cmdLine.getText();

        if (script.length() > 0)
        {
            cmdLine.setVisible(false);
            scriptLine.setVisible(true);

            Globals gl = JsePlatform.standardGlobals();

            try
            {
                LuaValue lv = gl.load(script).call();

                scriptLine.setText(lv.call().toString());
            }
            catch (LuaError error)
            {
                scriptLine.setText(TextFormatting.RED+error.toString());
            }
        }
    }

    private void onClickSaveFile(int i, int i1, int i2)
    {
        NBTTagCompound data = new NBTTagCompound();
        data.setString("appSave", cmdLine.getText());
        File saveFile = new File(newFileName + ".lua",this,data);
        Dialog.SaveFile saveD = new Dialog.SaveFile(this, data);
        saveD.setResponseHandler((success, file) ->
        {
            if (success)
            {
                successL.setVisible(true);
                return true;
            }
            return false;
        });
        openDialog(saveD);
    }

    @Override
    public void load(NBTTagCompound tagCompound) {

    }


    @Override
    public void save(NBTTagCompound tagCompound) {

    }
}
