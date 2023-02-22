package ITSpaceAcademy.homeworks.medicalCenter;

import ITSpaceAcademy.homeworks.medicalCenter.model.Doctor;
import ITSpaceAcademy.homeworks.medicalCenter.model.Patient;
import ITSpaceAcademy.homeworks.medicalCenter.storage.DoctorsStorage;
import ITSpaceAcademy.homeworks.medicalCenter.storage.PatientsStorage;
import ITSpaceAcademy.homeworks.medicalCenter.util.DateUtil;

import java.util.Scanner;

public class medicalCenterDemo implements Commands{

    static Scanner scanner = new Scanner(System.in);
    static DoctorsStorage doctorsStorage = new DoctorsStorage();
    static PatientsStorage patientsStorage = new PatientsStorage();

    public static void main(String[] args) {

        Doctor doctor = new Doctor("dr001","Doctor", "Doctoryan",
                "123456789", "doctor.@gmail.com","dentist");
        doctorsStorage.add(doctor);

        Patient patient1 = new Patient("pt001","Patient1", "Patientyan1", "234567891",doctor,
                DateUtil.stringToDayDate("22-02-2023"), DateUtil.stringToTimeDate("15:00"));
        Patient patient2 = new Patient("pt002","Patient2", "Patientyan2", "98452",doctor,
                DateUtil.stringToDayDate("22-02-2023"), DateUtil.stringToTimeDate("15:15"));
        Patient patient3 = new Patient("pt003","Patient3", "Patientyan3", "4565522",doctor,
                DateUtil.stringToDayDate("22-02-2023"), DateUtil.stringToTimeDate("15:30"));

        boolean exit = false;
        while(!exit){
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command){
                case EXIT :
                    exit = true;
                    break;
                case ADD_DOCTOR :
                    addDoctor();
                    break;
                case SEARCH_DOCTOR_BY_PROFESSION :
                    break;
                case DELETE_DOCTOR_BY_ID :
                    break;
                case CHANGE_DOCTOR_DATA_BY_ID:
                    break;
                case ADD_PATIENT :
                    break;
                case PRINT_ALL_PATIENTS_BY_DOCTOR :
                    break;
                case PRINT_TODAYS_PATIENTS :
                    break;
                default:
                    System.out.println("Wrong command, please try again");
                    break;
            }
        }
    }

    private static void addDoctor() {
        System.out.println("Please input doctor's id, name, surname, phone, email, profession");
        String doctorStrLine = scanner.nextLine();
        String[] doctorStrArr = doctorStrLine.split(",");
        String id = doctorStrArr[0];

    }
}
