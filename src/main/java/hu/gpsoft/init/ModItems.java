package hu.gpsoft.init;

import hu.gpsoft.items.ItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    //Initial release

    public static final Item SCREEN_PIECE = new ItemBase("screen_piece");

    //2nd update

    public static final Item cd = new ItemBase("cd");
    public static final Item telephone = new ItemBase("telephone");
}
