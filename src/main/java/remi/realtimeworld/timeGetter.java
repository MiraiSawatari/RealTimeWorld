package remi.realtimeworld;

import java.util.Calendar;
import java.util.TimeZone;

public class timeGetter {
    public static int getMinecraftTimeFromTime(String tz) {
        Calendar cal = Calendar.getInstance();
        TimeZone tzn = TimeZone.getTimeZone(tz);
        cal.setTimeZone(tzn);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        int milli = cal.get(Calendar.MILLISECOND);
        int current = ((hour * 60 + minute) * 60 + second) * 1000 + milli;

        return ((int) (current / 3600) + 18000) % 24000;
    }
}
