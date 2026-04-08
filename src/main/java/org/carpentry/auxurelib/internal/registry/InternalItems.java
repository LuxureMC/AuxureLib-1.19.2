package org.carpentry.auxurelib.internal.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.carpentry.auxurelib.internal.registry.item.TestItem;

import static org.carpentry.auxurelib.core.AuxureLib.MOD_ID;

public class InternalItems {

    public static final Item TEST_1 = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "test_1"), new TestItem(new Item.Settings()));

    public static void init(){

    }
}
