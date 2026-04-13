package org.carpentry.auxurelib.core.util;

@SuppressWarnings("unused")
public class TimeUtils {

    // converts a number of ticks to seconds.
    public static int seconds(int ticks){
        return ticks * 20;
    }

    // converts a number of ticks to minutes.
    public static int minutes(int ticks){
        return ticks * 1200;
    }
}