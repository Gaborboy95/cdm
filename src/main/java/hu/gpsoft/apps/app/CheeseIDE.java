package hu.gpsoft.apps.app;

import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.Layout;
import com.mrcrayfish.device.api.app.component.Label;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import static net.minecraft.client.gui.Gui.drawRect;
import static net.minecraftforge.fml.client.config.GuiUtils.drawTexturedModalRect;

public class CheeseIDE extends Application
{
    public Layout ideLayout;
    public Label welcomeLabel;

    @Override
    public void init(net.minecraft.nbt.NBTTagCompound nbtTagCompound) {
        ideLayout = new Layout(362, 164);
        this.setCurrentLayout(ideLayout);

        renderOverlay();

        welcomeLabel = new Label("Hello there!", 10, 10);
        ideLayout.addComponent(welcomeLabel);
    }

    @SubscribeEvent
    public void renderOverlay()
    {
        GL11.glPushMatrix();
        drawRect(0,0,362,164,0xFFFFA100);
        GL11.glPopMatrix();
    }

    @Override
    public void load(net.minecraft.nbt.NBTTagCompound nbtTagCompound) {

    }

    @Override
    public void save(net.minecraft.nbt.NBTTagCompound nbtTagCompound) {

    }
}
