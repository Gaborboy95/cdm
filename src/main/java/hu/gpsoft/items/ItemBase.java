package hu.gpsoft.items;

import hu.gpsoft.GPSoft;
import hu.gpsoft.init.ModItems;
import hu.gpsoft.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{

    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        GPSoft.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
