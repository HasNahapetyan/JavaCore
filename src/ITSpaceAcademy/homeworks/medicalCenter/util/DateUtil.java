package ITSpaceAcademy.homeworks.medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy3");
    static final SimpleDateFormat SDTF = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public static boolean isSameDay(Date date1, Date date2) {
        return SDF.format(date1).equals(SDF.format(date2));
    }

    public static String dateTimeToString(Date date) {
        return SDTF.format(date);
    }

    static public Date stringToDateTime(String dateString) throws ParseException {
        return SDTF.parse(dateString);
    }
}
