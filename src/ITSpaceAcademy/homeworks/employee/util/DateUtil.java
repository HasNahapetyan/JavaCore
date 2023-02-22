package ITSpaceAcademy.homeworks.employee.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
    public static Date stringToDate(String dateString){
        if (dateString == null) {
            return null;
        }
        try {
            return SDF.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String dateToString(Date date){
        if (date == null) {
            return null;
        }
        return SDF.format(date);
    }
}
