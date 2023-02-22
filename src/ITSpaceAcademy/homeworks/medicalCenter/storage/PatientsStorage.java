package ITSpaceAcademy.homeworks.medicalCenter.storage;

import ITSpaceAcademy.homeworks.medicalCenter.model.Patient;

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

}
