package org.carpentry.auxurelib.internal.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.carpentry.auxurelib.internal.registry.item.TestItem;
import org.carpentry.auxurelib.core.AuxureLib;

public class InternalItems {
    //public static Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    public static final Item TEST_1 = Registry.register(Registry.ITEM, AuxureLib.id("test_1"), new TestItem(new Item.Settings()));

    // public static final Item TEST_1 = create("test_1", new TestItem(new Item.Settings()));

    // private static <T extends Item> T create(String name, T item) {
    //     ITEMS.put(item, AuxureLib.id(name));
    //     return item;
    // }

    public static void init() {
        //ITEMS.forEach((item, id) -> Registry.register(Registries.ITEM, id, item));
    }
    // excuse me, what? :sob:
    // a item helper method

    // aka a better way of registering items instead of the entire line right there
    // 'ITEMS' is a list of all registered items which is surprisingly useful
}