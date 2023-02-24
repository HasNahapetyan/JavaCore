package ITSpaceAcademy.homeworks.medicalCenter;

import ITSpaceAcademy.homeworks.medicalCenter.model.Doctor;
import ITSpaceAcademy.homeworks.medicalCenter.model.Patient;
import ITSpaceAcademy.homeworks.medicalCenter.storage.DoctorsStorage;
import ITSpaceAcademy.homeworks.medicalCenter.storage.PatientsStorage;
import ITSpaceAcademy.homeworks.medicalCenter.util.DateUtil;

import java.util.Date;
import java.util.Scanner;

public class MedicalCenterDemo implements Commands, CommandsToChangeDoctor{

    static Scanner scanner = new Scanner(System.in);
    static DoctorsStorage doctorsStorage = new DoctorsStorage();
    static PatientsStorage patientsStorage = new PatientsStorage();

    public static void main(String[] args) {

        Doctor doctor = new Doctor("dr001","Doctor", "Doctoryan",
                "123456789", "doctor.@gmail.com","dentist");
        doctorsStorage.add(doctor);

        patientsStorage.add( new Patient("pt001","Patient1", "PtSurname1", "234567891",doctor,
                DateUtil.stringToDayDate("22-02-2023"), DateUtil.stringToTimeDate("15:00")));
        patientsStorage.add( new Patient("pt002","Patient2", "PtSurname2", "98452",doctor,
                DateUtil.stringToDayDate("22-02-2023"), DateUtil.stringToTimeDate("15:15")));
        patientsStorage.add( new Patient("pt003","Patient3", "PtSurname3", "4565522",doctor,
                DateUtil.stringToDayDate("22-02-2023"), DateUtil.stringToTimeDate("15:30")));

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
                    searchDoctorByProfession();
                    break;
                case DELETE_DOCTOR_BY_ID :
                    deleteDoctorById();
                    break;
                case CHANGE_DOCTOR_DATA_BY_ID:
                    changeDoctorDataById();
                    break;
                case ADD_PATIENT :
                    addPatient();
                    break;
                case PRINT_ALL_PATIENTS_BY_DOCTOR :
                    printPatientsByDoctor();
                    break;
                case PRINT_TODAYS_PATIENTS :
                    printTodaysPatients();
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
        if (doctorsStorage.getDoctorById(id) == null) {
            doctorsStorage.add(new Doctor(id,doctorStrArr[1],doctorStrArr[2],doctorStrArr[3],doctorStrArr[4],doctorStrArr[5]));
            System.out.println("Doctor added");
        }else {
            System.out.println("Doctor with " + id + " id already exists");
        }
    }

    private static void searchDoctorByProfession() {
        doctorsStorage.print();
        System.out.println("Please input doctor profession.");
        String profession = scanner.nextLine();
        doctorsStorage.printDoctorsByProfession(profession);
    }

    private static void deleteDoctorById() {
        doctorsStorage.print();
        System.out.println("Please input doctor id");
        String id = scanner.nextLine();
        Doctor doctorById = doctorsStorage.getDoctorById(id);
        if (doctorById != null) {
            doctorsStorage.deleteDoctor(doctorById);
            System.out.println("Doctor with " + id + " id deleted");
        }else{
            System.out.println("where is no  doctor with " + id + " id, please try again.");
        }
    }

    private static void changeDoctorDataById() {
        doctorsStorage.print();
        System.out.println("Please input doctor id");
        String id = scanner.nextLine();
        Doctor doctorById = doctorsStorage.getDoctorById(id);
        if (doctorById != null) {
            boolean finishChanges = false;
            while (!finishChanges) {
                CommandsToChangeDoctor.printCommandsForChangingDoctor();
                String command = scanner.nextLine();
                switch (command) {
                    case FINISH_CHANGES :
                        finishChanges = true;
                        break;
                    case CHANGE_DOCTORS_NAME :
                        changeDoctorName(doctorById);
                        break;
                    case CHANGE_DOCTORS_SURNAME :
                        changeDoctorSurname(doctorById);
                        break;
                    case CHANGE_DOCTORS_PHONE :
                        changeDoctorPhone(doctorById);
                        break;
                    case CHANGE_DOCTORS_EMAIL :
                        changeDoctorEmail(doctorById);
                        break;
                    case CHANGE_DOCTORS_PROFESSION :
                        changeDoctorProfession(doctorById);
                        break;
                    default:
                        System.out.println("Wrong command, please try again");
                }
            }
        }else {
            System.out.println("where is no  doctor with " + id + " id, please try again.");
        }
    }
                private static void changeDoctorName(Doctor doctor) {
                    System.out.println("Please input doctor's new name");
                    String newName = scanner.nextLine();
                    doctor.setName(newName);
                    System.out.println(doctor);
                }

                private static void changeDoctorSurname(Doctor doctor) {
                    System.out.println("Please input doctor's new surname");
                    String newSurname = scanner.nextLine();
                    doctor.setSurname(newSurname);
                    System.out.println(doctor);
                }

                private static void changeDoctorPhone(Doctor doctor) {
                    System.out.println("Please input doctor's new phone");
                    String newSurname = scanner.nextLine();
                    doctor.setPhone(newSurname);
                    System.out.println(doctor);
                }

                private static void changeDoctorEmail(Doctor doctor) {
                    System.out.println("Please input doctor's new email");
                    String newEmail = scanner.nextLine();
                    doctor.setEmail(newEmail);
                    System.out.println(doctor);
                }

                private static void changeDoctorProfession(Doctor doctor) {
                    System.out.println("Please input doctor's new profession");
                    String newProfession = scanner.nextLine();
                    doctor.setProfession(newProfession);
                    System.out.println(doctor);
                }

    private static void addPatient() {
        if(doctorsStorage.getSize() == 0) {
            System.out.println("Please add doctor first!");
            return;
        }
        System.out.println("Please input doctor's id");
        String doctorId = scanner.nextLine();
        Doctor doctorById = doctorsStorage.getDoctorById(doctorId);
        if (doctorById != null) {
            System.out.println("Please input patient's cardId, name, surname, phone, day(22-01-2023), time(15:30) ");
            String patientStrLine = scanner.nextLine();
            String[] patientStrArr = patientStrLine.split(",");
            //String cardId = patientStrArr[0];//same patient can register a few times (maybe)
            String day = patientStrArr[4];
            String time = patientStrArr[5];
            Date dayDate = DateUtil.stringToDayDate(day);
            Date timeDate = DateUtil.stringToTimeDate(time);
            boolean isBusy = patientsStorage.dayTimeIsBusy(doctorById, dayDate, timeDate);
            if(isBusy){
                System.out.println(day + " " + time + " time is busy with " +  doctorById + " doctor");
            }else{
                patientsStorage.add(new Patient(patientStrArr[0], patientStrArr[1],patientStrArr[2], patientStrArr[3],
                        doctorById ,dayDate, timeDate));
                System.out.println("Patient added");
            }
        }else{
            System.out.println("Doctor with " + doctorId + " id does not exist.");
        }
    }


    private static void printPatientsByDoctor() {
        System.out.println("Please input doctor's id");
        String doctorId = scanner.nextLine();
        Doctor doctorById = doctorsStorage.getDoctorById(doctorId);
        if (doctorById != null){
            patientsStorage.printPatientsByDoctor(doctorById);
        }else{
            System.out.println("Doctor with " + doctorId + " id does not exist.");
        }
    }

    private static void printTodaysPatients() {
        if(patientsStorage.getSize() == 0){
            System.out.println("No Patient");
            return;
        }
        Date date = new Date();
        patientsStorage.printTodaysPatients(date);
    }
}
