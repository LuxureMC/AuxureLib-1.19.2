package org.carpentry.auxurelib.core.util;

public class TimeUtils {
    /**
     * Converts a number of ticks to seconds.
     * @param ticks The ticks to convert.
     * @return ticks as seconds.
     */
    public static int seconds(int ticks){
        return ticks * 20;
    }
    /**
     * Converts a number of ticks to minutes.
     * @param ticks The ticks to convert.
     * @return ticks as minutes.
     */
    public static int minutes(int ticks){
        return ticks * 1200;
    }
}