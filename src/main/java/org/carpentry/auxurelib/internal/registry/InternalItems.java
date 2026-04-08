package org.carpentry.auxurelib.internal.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.carpentry.auxurelib.internal.registry.item.TestItem;

import static org.carpentry.auxurelib.core.AuxureLib.MOD_ID;

public class InternalItems {
    //public static Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    public static final Item TEST_1 = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "test_1"), new TestItem(new Item.Settings()));

    // public static final Item TEST_1 = create("test_1", new TestItem(new Item.Settings()));

    // private static <T extends Item> T create(String name, T item) {
    //     ITEMS.put(item, AuxureLib.id(name));
    //     return item;
    // }

    public static void init() {
        //ITEMS.forEach((item, id) -> Registry.register(Registries.ITEM, id, item));
    }
}