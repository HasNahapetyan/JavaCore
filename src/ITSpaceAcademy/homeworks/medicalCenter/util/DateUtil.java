package ITSpaceAcademy.homeworks.medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    static final SimpleDateFormat DAY_FORMATTER = new SimpleDateFormat("dd-MM-yyyy");
    static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("HH:mm");

    static public String dayDateToString(Date date){
        if (date == null) {
            return null;
        }
        return DAY_FORMATTER.format(date);
    }
    static public Date stringToDayDate(String dayString){
        if (dayString == null) {
            return null;
        }
        try {
            return DAY_FORMATTER.parse(dayString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    static public String timeDateToString(Date time){
        if (time == null) {
            return null;
        }
        return TIME_FORMATTER.format(time);
    }
    static public Date stringToTimeDate(String timeString){
        if (timeString == null) {
            return null;
        }
        try {
            return TIME_FORMATTER.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
