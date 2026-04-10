package org.carpentry.auxurelib.core.util;

public class TimeUtils {

    public static int ticksToSeconds(int ticks){
        return ticks / 20;
    }

    public static int secondsToTicks(int ticks){
        return ticks * 20;
    }

    public static int ticksToMinutes(int ticks){
        return ticks * 1200;
    }
}
