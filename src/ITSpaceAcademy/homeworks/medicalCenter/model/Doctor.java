package ITSpaceAcademy.homeworks.medicalCenter.model;

import ITSpaceAcademy.homeworks.medicalCenter.ProfessionEnum;

import java.util.Objects;

public class Doctor extends Person{

    private String email;
    private ProfessionEnum profession;

    public Doctor(String id, String name, String surname, String phone, String email, ProfessionEnum profession) {
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

    public ProfessionEnum getProfession() {
        return profession;
    }

    public void setProfession(ProfessionEnum profession) {
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
