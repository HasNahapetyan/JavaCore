package ITSpaceAcademy.homeworks.medicalCenter;

public interface Commands {
    static final String EXIT = "0";
    static final String ADD_DOCTOR= "1";
    static final String SEARCH_DOCTOR_BY_PROFESSION  = "2";
    static final String DELETE_DOCTOR_BY_ID = "3";
    static final String CHANGE_DOCTOR_DATA_BY_ID = "4";
    static final String ADD_PATIENT/*(ընտրելու եք բժշկին, բայց ստուգեք որ էդ ժամը զբաղված չլինի)*/ = "5";
    static final String PRINT_ALL_PATIENTS_BY_DOCTOR = "6";
    static final String PRINT_TODAYS_PATIENTS = "7";

    static void printCommands(){
        System.out.println("Please input " + EXIT + " to exit");
        System.out.println("Please input " + ADD_DOCTOR + " to add doctor");
        System.out.println("Please input " + SEARCH_DOCTOR_BY_PROFESSION + " to search doctor by profession");
        System.out.println("Please input " + DELETE_DOCTOR_BY_ID + " to delete doctor by id");
        System.out.println("Please input " + CHANGE_DOCTOR_DATA_BY_ID + " change doctor data by id");
        System.out.println("Please input " + ADD_PATIENT + " to add patient");

        System.out.println("Please input " + PRINT_ALL_PATIENTS_BY_DOCTOR + " to print all  patients by doctor");
        System.out.println("Please input " + PRINT_TODAYS_PATIENTS + " to print today's patients");
    }

}
