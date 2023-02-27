package ITSpaceAcademy.homeworks.medicalCenter;

import ITSpaceAcademy.chapters.chapter12.Language;
import ITSpaceAcademy.homeworks.medicalCenter.model.Doctor;
import ITSpaceAcademy.homeworks.medicalCenter.model.Patient;
import ITSpaceAcademy.homeworks.medicalCenter.storage.PersonStorage;
import ITSpaceAcademy.homeworks.medicalCenter.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class MedicalCenterDemo implements Commands, CommandsToChangeDoctor{

    static Scanner scanner = new Scanner(System.in);
    static PersonStorage personsStorage = new PersonStorage();

    public static void main(String[] args) {

        Doctor doctor = new Doctor("dr001","Doctor", "Doctoryan",
                "123456789", "doctor@gmail.com",ProfessionEnum.EMERGENCY_PHYSICIANS);
        personsStorage.add(doctor);

        try {
            personsStorage.add( new Patient("pt001","Patient1", "PtSurname1", "234567891",doctor,
                    DateUtil.stringToDateTime("22-02-2023 15:00")));
            personsStorage.add( new Patient("pt002","Patient2", "PtSurname2", "98452",doctor,
                    DateUtil.stringToDateTime("22-02-2023 15:15")));
            personsStorage.add( new Patient("pt003","Patient3", "PtSurname3", "4565522",doctor,
                    DateUtil.stringToDateTime("22-02-2023 15:30")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
        System.out.println("Please input doctor's id, name, surname, phone, email, profession(Please choose doctor's profession from the list below)");
        ProfessionEnum[] professions = ProfessionEnum.values();
        for (ProfessionEnum profession:
                professions) {
            System.out.println(profession);
        }

        String doctorStrLine = scanner.nextLine();
        String[] doctorStrArr = doctorStrLine.split(",");
        String id = doctorStrArr[0];
        if (personsStorage.getDoctorById(id) == null) {

            ProfessionEnum profession;
            try{
                profession = ProfessionEnum.valueOf(doctorStrArr[5]);
                personsStorage.add(new Doctor(id,doctorStrArr[1],doctorStrArr[2],doctorStrArr[3],doctorStrArr[4],profession));
                System.out.println("Doctor added");
            }catch (RuntimeException e){
                System.out.println("Wrong profession input, please try again");
            }
        }else {
            System.out.println("Doctor with " + id + " id already exists");
        }
    }

    private static void searchDoctorByProfession() {
        personsStorage.printDoctors();
        System.out.println("Please input doctor profession from the list.");
        ProfessionEnum[] professions = ProfessionEnum.values();
        for (ProfessionEnum profession:
                professions) {
            System.out.println(profession);
        }

        String professionStr = scanner.nextLine();

        ProfessionEnum profession;
        try{
            profession = ProfessionEnum.valueOf(professionStr);
            personsStorage.printDoctorsByProfession(profession);

        }catch (RuntimeException e){
            System.out.println("Wrong profession input, please try again");
        }
    }

    private static void deleteDoctorById() {
        personsStorage.printDoctors();
        System.out.println("Please input doctor id");
        String id = scanner.nextLine();
        Doctor doctorById = personsStorage.getDoctorById(id);
        if (doctorById != null) {
            personsStorage.deleteDoctorById(id);
            System.out.println("Doctor with " + id + " id deleted");
        }else{
            System.out.println("where is no  doctor with " + id + " id, please try again.");
        }
    }

    private static void changeDoctorDataById() {
        personsStorage.printDoctors();
        System.out.println("Please input doctor id");
        String id = scanner.nextLine();
        Doctor doctorById = personsStorage.getDoctorById(id);
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
                    System.out.println("Please input doctor's new profession from list");
                    ProfessionEnum[] professions = ProfessionEnum.values();
                    for (ProfessionEnum profession:
                         professions) {
                        System.out.println(profession);
                    }
                    String newProfessionStr = scanner.nextLine();
                    try{
                        doctor.setProfession(ProfessionEnum.valueOf(newProfessionStr));
                        System.out.println(doctor);
                    }catch (RuntimeException e){
                        System.out.println("Wrong profession input, please try again");
                    }
                }

    private static void addPatient() {
        System.out.println("Please input doctor's id");
        String doctorId = scanner.nextLine();
        Doctor doctorById = personsStorage.getDoctorById(doctorId);
        if (doctorById != null) {
            System.out.println("Please input patient's cardId, name, surname, phone, date(22-01-2023 15:30) ");
            String patientStrLine = scanner.nextLine();
            String[] patientStrArr = patientStrLine.split(",");
            //String cardId = patientStrArr[0];//same patient can register a few times (maybe)
            String dateStr = patientStrArr[4];
            Date date = null;
            try {
                date = DateUtil.stringToDateTime(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            boolean isBusy = personsStorage.dayTimeIsBusy(doctorById, date);
            if(isBusy){
                System.out.println(dateStr + " time is busy with " +  doctorById + " doctor");
            }else{
                personsStorage.add(new Patient(patientStrArr[0], patientStrArr[1],patientStrArr[2], patientStrArr[3],
                        doctorById ,date));
                System.out.println("Patient added");
            }
        }else{
            System.out.println("Doctor with " + doctorId + " id does not exist.");
        }
    }


    private static void printPatientsByDoctor() {
        System.out.println("Please input doctor's id");
        String doctorId = scanner.nextLine();
        Doctor doctorById = personsStorage.getDoctorById(doctorId);
        if (doctorById != null){
            personsStorage.searchPatientByDoctor(doctorById);
        }else{
            System.out.println("Doctor with " + doctorId + " id does not exist.");
        }
    }

    private static void printTodaysPatients() {
        if(personsStorage.getSize() == 0){
            System.out.println("No Patient");
            return;
        }
        personsStorage.printTodaysPatients();
    }
}
