package ITSpaceAcademy.homeworks.medicalCenter;

public interface CommandsToChangeDoctor {
    public static final String FINISH_CHANGES = "0";
    public static final String CHANGE_DOCTORS_NAME = "1";
    public static final String CHANGE_DOCTORS_SURNAME = "2";
    public static final String CHANGE_DOCTORS_PHONE = "3";
    public static final String CHANGE_DOCTORS_EMAIL = "4";
    public static final String CHANGE_DOCTORS_PROFESSION = "5";

    public static void printCommandsForChangingDoctor(){
        System.out.println("Please input " + FINISH_CHANGES + " to finish changes");
        System.out.println("Please input " + CHANGE_DOCTORS_NAME + " to change doctor's name");
        System.out.println("Please input " + CHANGE_DOCTORS_SURNAME + " to change doctor's surname");
        System.out.println("Please input " + CHANGE_DOCTORS_PHONE + " to change doctor's phone");
        System.out.println("Please input " + CHANGE_DOCTORS_EMAIL + " to change doctor's email");
        System.out.println("Please input " + CHANGE_DOCTORS_PROFESSION + " to change doctor's profession");
    }
}
