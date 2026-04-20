package org.carpentry.auxurelib.core.util;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class TooltipHelper {
    /**
     * Creates a tooltip based on a translation key.
     * @param key The translation key of the tooltip.
     * @param formatting The formatting(s) to apply.
     */
    public static MutableText createTranslated(String key, Formatting... formatting) {
        MutableText text = Text.translatable(key);
        for (Formatting f : formatting) text = text.formatted(f);
        return text;
    }

    /**
     * Creates a tooltip based on a literal given text.
     * @param content The text to display
     * @param formatting The formatting(s) to apply..
     */
    public static MutableText createLiteral(String content, Formatting... formatting) {
        MutableText text = Text.literal(content);
        for (Formatting f : formatting) text = text.formatted(f);
        return text;
    }
}