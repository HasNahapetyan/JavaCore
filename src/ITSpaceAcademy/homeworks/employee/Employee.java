package ITSpaceAcademy.homeworks.employee;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String id;
    private Double salary;
    private String company;
    private String position;
    private boolean active = true;
    private Date registerDate;
    private Date dateOfBirthday;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public Employee() {
    }

    public Employee(String name, String surname, String id, Double salary, String company, String position,Date dateOfBirthday ) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.salary = salary;
        this.company = company;
        this.position = position;
        this.registerDate = new Date();
        this.dateOfBirthday = dateOfBirthday;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return isActive() == employee.isActive() && Objects.equals(getName(), employee.getName()) && Objects.equals(getSurname(), employee.getSurname()) && Objects.equals(getId(), employee.getId()) && Objects.equals(getSalary(), employee.getSalary()) && Objects.equals(getCompany(), employee.getCompany()) && Objects.equals(getPosition(), employee.getPosition()) && Objects.equals(getRegisterDate(), employee.getRegisterDate()) && Objects.equals(getDateOfBirthday(), employee.getDateOfBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getId(), getSalary(), getCompany(), getPosition(), isActive(), getRegisterDate(), getDateOfBirthday());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id='" + id + '\'' +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", active=" + active +
                ", registerDate=" + registerDate +
                ", dateOfBirthday=" + dateOfBirthday +
                '}';
    }
}
