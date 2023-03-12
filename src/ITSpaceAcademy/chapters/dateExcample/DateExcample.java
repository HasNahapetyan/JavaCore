package ITSpaceAcademy.chapters.dateExcample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExcample {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);

        SimpleDateFormat sdf = new SimpleDateFormat("hh");
        String d2 = sdf.format(d1);
        System.out.println(d2);
        sdf.applyPattern("dd");
        String d3 = sdf.format(d1);
        System.out.println(d3);
        System.out.println(sdf.getDateFormatSymbols());
        System.out.println(sdf.getCalendar());
    }
}
