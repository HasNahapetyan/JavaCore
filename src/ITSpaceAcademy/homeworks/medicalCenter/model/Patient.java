package ITSpaceAcademy.homeworks.medicalCenter.model;

import ITSpaceAcademy.homeworks.medicalCenter.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Patient extends Person{

    private Doctor doctor;
    private Date registerDate;
    private Date registerTime;

    public Patient(String id, String name, String surname, String phone, Doctor doctor, Date date, Date time) {
        super(id, name, surname, phone);
        this.doctor = doctor;
        this.registerDate = date;
        this.registerTime = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getDoctor(), patient.getDoctor()) && Objects.equals(getRegisterDate(), patient.getRegisterDate()) && Objects.equals(getRegisterTime(), patient.getRegisterTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDoctor(), getRegisterDate(), getRegisterTime());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", doctor=" + doctor +
                ", date=" + DateUtil.dayDateToString(registerDate) +
                ", time=" + DateUtil.timeDateToString(registerTime) +
                '}';
    }
}
