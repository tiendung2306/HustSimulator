package time;

public class TimeSystem {
    public static int day = 4;
    public static String currentTime = "88:88";

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
