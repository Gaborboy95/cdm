package hu.gpsoft.apps.app;

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.Icons;
import com.mrcrayfish.device.api.app.Layout;
import com.mrcrayfish.device.api.app.component.Button;
import com.mrcrayfish.device.api.app.component.Label;

public class CheeseIDE extends Application
{
    public Layout ideLayout;
    public Label welcomeLabel;
    public Button fileButton;

    @Override
    public void init(net.minecraft.nbt.NBTTagCompound nbtTagCompound) {
        ideLayout = new Layout(362, 164);
        this.setCurrentLayout(ideLayout);

        welcomeLabel = new Label("Hello there!", 10, 10);
        ideLayout.addComponent(welcomeLabel);

        fileButton = new Button(167,68, 28, 28, Icons.FILE);
        ideLayout.addComponent(fileButton);
    }

    @Override
    public void load(net.minecraft.nbt.NBTTagCompound nbtTagCompound) {

    }

    @Override
    public void save(net.minecraft.nbt.NBTTagCompound nbtTagCompound) {

    }
}