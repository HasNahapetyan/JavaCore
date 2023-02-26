package ITSpaceAcademy.homeworks.medicalCenter.model;

import ITSpaceAcademy.homeworks.medicalCenter.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Patient extends Person{

    private Doctor doctor;
    private Date registerDateTime;

    public Patient(String id, String name, String surname, String phone, Doctor doctor, Date date) {
        super(id, name, surname, phone);
        this.doctor = doctor;
        this.registerDateTime = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(Date registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getDoctor(), patient.getDoctor()) && Objects.equals(getRegisterDateTime(), patient.getRegisterDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDoctor(), getRegisterDateTime());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", doctor=" + doctor +
                ", date=" + DateUtil.dateTimeToString(registerDateTime) +
                '}';
    }
}
