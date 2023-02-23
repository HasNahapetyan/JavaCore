package ITSpaceAcademy.homeworks.medicalCenter.storage;

import ITSpaceAcademy.homeworks.medicalCenter.model.Doctor;
import ITSpaceAcademy.homeworks.medicalCenter.model.Patient;
import ITSpaceAcademy.homeworks.medicalCenter.util.DateUtil;

import java.util.Date;

public class PatientsStorage {

    private Patient[] patients = new Patient[10];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(Patient patient) {
        if(size == patients.length){
            extend();
        }
        patients[size] = patient;
        size++;
    }

    private void extend() {
        Patient[] array1 = new Patient[size+10];
        if (size >= 0) System.arraycopy(patients, 0, array1, 0, size);
        patients = array1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(patients[i] + " ");
        }
    }

    public boolean dayTimeIsBusy(Doctor doctor, Date day, Date time) {
        for (int i = 0; i < size; i++) {
            Patient patient = patients[i];
            if(patient.getDoctor().equals(doctor) && patient.getRegisterDate().equals(day)
                    && patient.getRegisterTime().equals(time)){
                return true;
            }
        }
        return false;
    }

    public void printPatientsByDoctor(Doctor doctor) {
        for (int i = 0; i < size; i++) {
            Patient patient = patients[i];
            if (patient.getDoctor().equals(doctor)){
                System.out.println(patient);
            }
        }
    }

    public void printTodaysPatients(Date date) {
        for (int i = 0; i < size; i++) {
            Patient patient = patients[i];
            if (DateUtil.dayDateToString(patient.getRegisterDate()).equals(DateUtil.dayDateToString(date))){
                System.out.println(patient);
            }
        }
    }
}
