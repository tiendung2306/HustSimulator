package time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeSystem {
    public static int day = 1;
    public static String currentTime = "88:88";

    public static long currentSystemTime = 0; // thoi gian tu luc bat dau game den gio (tinh theo nano giay)
    public static long startSystemTime = 0;
    public static long savedElapsedTime = 0;
    public static String currentPlayDate = "88/88/8888";

    public TimeSystem() {
        startSystemTime = System.nanoTime();
    }

    public void update() {
        currentSystemTime = System.nanoTime() - startSystemTime;
    }

    static public long getCurrentSystemTimeInMilliseconds() {
        return currentSystemTime / 1000000;
    }

    static public String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static void setCurrentTime(String time) {
        currentTime = time;
    }

    public static void goNextDay() {
        day++;
    }

    public static void goBackDay() { // who need this shjtty kind of func??? //yea no one need this shjt
        day--;
    }
}
