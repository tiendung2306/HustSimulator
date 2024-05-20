package phone;

import java.util.ArrayList;

class Subject {
    String subjectName;
    String timeAndLocation;

    public Subject(String subjectName, String timeAndLocation) {
        this.subjectName = subjectName;
        this.timeAndLocation = timeAndLocation;
    }
}

public class Schedule {
    ArrayList<Subject> Subjects = new ArrayList<Subject>();
    Subject vldc = new Subject("Vật lý đại cương I - PH1110", "6h45 - 9h30, D5-302");
    Subject tthcm = new Subject("Tư tưởng HCM - SSH1151", "6h45 - 9h30, D3-201");
    Subject ds = new Subject("Đại số - MI1141", "6h45 - 9h30, D3-302");
    Subject pldc = new Subject("Pháp luật đại cương - EM1170", "9h45 - 11h30, D3-5-401");
    Subject nmcntt_lt = new Subject("Nhập môn CNTT&TT - IT2000", "9h45 - 11h45, D3-201");
    Subject gt = new Subject("Giải tích I - MI1110", "9h45 - 11h45, D3-301");
    Subject nmcntt_th1 = new Subject("Nhập môn CNTT&TT - IT2000", "12h30 - 15h50, B1-302");
    Subject nmcntt_th2 = new Subject("Nhập môn CNTT&TT - IT2000", "16h05 - 17h30, B1-302");

    Subject dailySchedule[][] = new Subject[101][5];
    int numOfPeroidPerDay[] = new int[101];

    void addDailySchedule(int day, Subject subject) {
        dailySchedule[day][numOfPeroidPerDay[day]] = subject;
        numOfPeroidPerDay[day] ++;
    }

    Subject getDailySchedule(int day, int peroid) { //peroid tinh tu 1, hieu la tiet 1 tiet 2 tiet 3 cua ngay
        if(peroid > numOfPeroidPerDay[day]) return null;
        return dailySchedule[day][peroid - 1];
    }

    public void Init() {
        Subjects.add(vldc);
        Subjects.add(gt);
        Subjects.add(ds);
        Subjects.add(nmcntt_lt);
        Subjects.add(nmcntt_th1);
        Subjects.add(nmcntt_th2);
        Subjects.add(tthcm);
        Subjects.add(pldc);

        addDailySchedule(2, gt);
        addDailySchedule(2, ds);

        addDailySchedule(3, tthcm);
        addDailySchedule(3, nmcntt_lt);

        addDailySchedule(4, pldc);

        addDailySchedule(5, ds);
        addDailySchedule(5, gt);
        addDailySchedule(5, nmcntt_th1);
        addDailySchedule(5, nmcntt_th2);
    }

}