package org.carpentry.auxurelib.core.util;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class TooltipHelper {

    // Creates a tooltip based on a translation key (Text.translatable)
    // @param key the translation key of the tooltip
    // @param formatting the text formatting of the tooltip

    public static MutableText createTranslated(String key, Formatting... formatting) {
        MutableText text = Text.translatable(key);
        for (Formatting f : formatting) text = text.formatted(f);
        return text;
    }

    // Creates a tooltip based on literal text (Text.literal)
    // @param content the content of the tooltip
    // @param formatting the text formatting of the tooltip

    public static MutableText createLiteral(String content, Formatting... formatting) {
        MutableText text = Text.literal(content);
        for (Formatting f : formatting) text = text.formatted(f);
        return text;
    }
}
