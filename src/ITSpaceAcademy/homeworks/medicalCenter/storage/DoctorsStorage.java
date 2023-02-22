package ITSpaceAcademy.homeworks.medicalCenter.storage;

import ITSpaceAcademy.homeworks.employee.model.Company;
import ITSpaceAcademy.homeworks.medicalCenter.model.Doctor;

public class DoctorsStorage {

    private Doctor[] doctors = new Doctor[10];
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(Doctor doctor) {
        if(size == doctors.length){
            extend();
        }
        doctors[size] = doctor;
        size++;
    }

    private void extend() {
        Doctor[] array1 = new Doctor[size+10];
        if (size >= 0) System.arraycopy(doctors, 0, array1, 0, size);
        doctors = array1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i] + " ");
        }
    }

}
