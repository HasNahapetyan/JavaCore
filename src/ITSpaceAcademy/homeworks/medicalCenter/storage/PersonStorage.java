package ITSpaceAcademy.homeworks.medicalCenter.storage;

import ITSpaceAcademy.homeworks.medicalCenter.ProfessionEnum;
import ITSpaceAcademy.homeworks.medicalCenter.model.Doctor;
import ITSpaceAcademy.homeworks.medicalCenter.model.Patient;
import ITSpaceAcademy.homeworks.medicalCenter.model.Person;
import ITSpaceAcademy.homeworks.medicalCenter.util.DateUtil;

import java.util.Date;

public class PersonStorage {
    private Person[] persons = new Person[10];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(Person doctor) {
        if(size == persons.length){
            extend();
        }
        persons[size] = doctor;
        size++;
    }

    private void extend() {
        Person[] array1 = new Person[size+10];
        if (size >= 0) System.arraycopy(persons, 0, array1, 0, size);
        persons = array1;
    }

    public void printDoctors() {
        for (int i = 0; i < size; i++) {
            Person person = persons[i];
            if(person instanceof Doctor){
                System.out.println(person);
            }
        }
    }

    public void printPatients() {
        for (int i = 0; i < size; i++) {
            Person person = persons[i];
            if(person instanceof Patient){
                System.out.println(person);
            }
        }
    }
    public Doctor getDoctorById(String id){
        for (int i = 0; i < size; i++) {
            Person person = persons[i];
            if (person instanceof Doctor && person.getId().equals(id)){
                return (Doctor) person;
            }
        }
        return null;
    }

    public void printDoctorsByProfession(ProfessionEnum profession) {
        for (int i = 0; i < size; i++) {
            Person person = persons[i];
            if(person instanceof Doctor) {
                Doctor doctor  = (Doctor) person;
                if (doctor.getProfession().equals(profession)) {
                    System.out.println(doctor);
                }
            }
        }
    }

    public void deleteDoctorById(String id) {
        for (int i = 0; i < size; i++) {
            Person person = persons[i];
            if (person instanceof Doctor && person.getId().equals(id)){
                if (size - 1 - i >= 0)
                    deletePersonByIndex(i);
                break;
            }
        }
    }
    private void deletePersonByIndex(int i){
        for (int j = i; j < size; j++) {
            persons[j] = persons[j+1];
        }
        size--;
    }
    public void searchPatientByDoctor(Doctor doctor){
        for (int i = 0; i < size; i++) {
            Person person = persons[i];
            if(person instanceof Patient){
                Patient patient = (Patient) person;
                if (patient.getDoctor().equals(doctor)){
                    System.out.println(patient);
                }
            }

        }
    }

    public void printTodaysPatients() {
        Date today = new Date();
        for (int i = 0; i < size; i++) {
            Person person = persons[i];
            if(person instanceof Patient) {
                Patient patient = (Patient) person;
                if(DateUtil.isSameDay(today,patient.getRegisterDateTime())){
                    System.out.println(patient);
                }
            }

        }
    }

    public boolean dayTimeIsBusy(Doctor doctor, Date date) {
        for (int i = 0; i < size; i++) {
            if(persons[i] instanceof Patient){
                Patient patient = (Patient) persons[i];
                if(patient.getDoctor().equals(doctor) && patient.getRegisterDateTime().equals(date))
                return false;
            }
        }
        return true;
    }
}
