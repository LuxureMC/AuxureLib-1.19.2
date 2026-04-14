package org.carpentry.auxurelib.core.interfaces;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface TwoHandedItem {
    /**
     * Determines if this weapon is two-handed.
     * @param stack The weapon ItemStack.
     */
    default boolean isTwoHanded(ItemStack stack) {
        return true;
    }

    /**
     * Prevents off-hand usage when holding a two-handed item.
     * @param player The player holding the Item.
     */
    static boolean canUseOffhand(PlayerEntity player) {
        ItemStack main = player.getMainHandStack();
        return main.getItem() instanceof TwoHandedItem tw && tw.isTwoHanded(main);
    }
}