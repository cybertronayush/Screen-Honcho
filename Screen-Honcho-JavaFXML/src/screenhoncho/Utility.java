
package ScreenHoncho;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Utility {
    
    public String getDate(String date, String dateFormat) {
        long milliSeconds = Long.parseLong(date);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public String getDate(long milliSeconds, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public String getDuration(int duration) {
        String time = "";
        duration /= 1000;
        int minutes = duration / 60;
        duration %= 60;
        if (minutes > 0) {
            time += minutes + " mins ";
        }
        time += duration + " secs";
        return time;
    }

    public String getSize(int size) {
        size /= 1024;
        return size + "KB";
    }

    public String getSize(long size) {
        size /= 1024;
        return size + "KB";
    }
    
}
