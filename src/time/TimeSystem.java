package time;

public class TimeSystem {
    public static int day = 4;
    public static String currentTime = "88:88";
    
    public static long currentSystemTime = 0; //thoi gian tu luc bat dau game den gio (tinh theo nano giay)
    public static long startSystemTime = 0;

    public TimeSystem() {
        startSystemTime = System.nanoTime();
    }

    public void update() {
        currentSystemTime = System.nanoTime() - startSystemTime;
    }

    static public long getCurrentSystemTimeInMilliseconds() {
        return currentSystemTime / 1000000;
    }

    public static void setCurrentTime(String time) {
        currentTime = time;
    }

    public static void goNextDay() {
        day++;
    }

    public static void goBackDay() { //who need this shjtty kind of func???
        day--;
    }
}
