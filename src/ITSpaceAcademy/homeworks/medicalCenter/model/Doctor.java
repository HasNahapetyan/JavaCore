package ITSpaceAcademy.homeworks.medicalCenter.model;

import java.util.Objects;

public class Doctor extends Person{

    private String email;
    private String profession;

    public Doctor(String id, String name, String surname, String phone, String email, String profession) {
        super(id, name, surname, phone);
        this.email = email;
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(getEmail(), doctor.getEmail()) && Objects.equals(getProfession(), doctor.getProfession());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEmail(), getProfession());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
