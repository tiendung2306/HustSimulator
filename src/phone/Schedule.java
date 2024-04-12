package phone;

import java.util.ArrayList;

class ClassPeroid {
    String subjectName;
    String timeAndLocation;

    public ClassPeroid(String subjectName, String timeAndLocation) {
        this.subjectName = subjectName;
        this.timeAndLocation = timeAndLocation;
    }
}

public class Schedule {
    ArrayList<ClassPeroid> classPeroids = new ArrayList<ClassPeroid>();
    ClassPeroid vldc = new ClassPeroid("Vật lý đại cương I - PH1110", "6h45 - 9h30, D5-302");
    ClassPeroid gt = new ClassPeroid("Giải tích I - MI1110", "9h45 - 11h45, D3-101");
    ClassPeroid ds = new ClassPeroid("Đại số - MI1141", "6h45 - 9h30, D3-101");
    ClassPeroid nmcntt_lt = new ClassPeroid("Nhập môn CNTT&TT - IT2000", "9h45 - 11h45, D3-201");
    ClassPeroid nmcntt_th1 = new ClassPeroid("Nhập môn CNTT&TT - IT2000", "12h30 - 15h50, B1-302");
    ClassPeroid nmcntt_th2 = new ClassPeroid("Nhập môn CNTT&TT - IT2000", "16h05 - 17h30, B1-302");
    ClassPeroid tthcm = new ClassPeroid("Tư tưởng HCM - SSH1151", "6h45 - 9h30, D3-201");
    ClassPeroid pldc = new ClassPeroid("Pháp luật đại cương - EM1170", "9h45 - 11h30, D3-5-401");

    public void Init() {
        classPeroids.add(vldc);
        classPeroids.add(gt);
        classPeroids.add(ds);
        classPeroids.add(nmcntt_lt);
        classPeroids.add(nmcntt_th1);
        classPeroids.add(nmcntt_th2);
        classPeroids.add(tthcm);
        classPeroids.add(pldc);
    }

}

