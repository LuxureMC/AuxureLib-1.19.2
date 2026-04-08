package org.carpentry.auxurelib.internal.registry.item;

import net.minecraft.item.Item;

public class TestItem extends Item {
    public TestItem(Settings settings) {
        super(settings.maxCount(1));
    }
}