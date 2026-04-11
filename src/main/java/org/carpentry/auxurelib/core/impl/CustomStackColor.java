package org.carpentry.auxurelib.core.impl;

import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public interface CustomStackColor {
    /** Sets the color of the Item name.
     *  @param stack The ItemStack.
     */
    int getHexColor(ItemStack stack);

    default Text getColoredName(ItemStack stack) {
        // Use the translation key
        MutableText name = Text.translatable(stack.getItem().getTranslationKey(stack));

        int hexColor = getHexColor(stack);
        int r = (hexColor >> 16) & 0xFF;
        int g = (hexColor >> 8) & 0xFF;
        int b = hexColor & 0xFF;

        return name.setStyle(name.getStyle().withColor((r << 16) | (g << 8) | b));
    } // why ts bitshifted guh
}

/*
Can also be done through the `getName` method in base Item.class,
return the base text, then add `.styled(style -> style.withColor(COLOR));`


    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().styled(style -> style.withColor(getNameColor(stack)));
    }
*/
