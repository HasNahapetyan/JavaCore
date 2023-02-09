package ITSpaceAcademy.homeworks.employee;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String id;
    private String salary;
    private String company;
    private String position;

    public Employee() {
    }

    public Employee(String name, String surname, String emplyeeID, String salary, String company, String position) {
        this.name = name;
        this.surname = surname;
        this.id = emplyeeID;
        this.salary = salary;
        this.company = company;
        this.position = position;
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

    public String getEmplyeeID() {
        return id;
    }

    public void setId(String emplyeeID) {
        this.id = emplyeeID;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
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
        return Objects.equals(getName(), employee.getName()) && Objects.equals(getSurname(), employee.getSurname()) && Objects.equals(id, employee.id) && Objects.equals(getSalary(), employee.getSalary()) && Objects.equals(getCompany(), employee.getCompany()) && Objects.equals(getPosition(), employee.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), id, getSalary(), getCompany(), getPosition());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", emplyeeID='" + id + '\'' +
                ", salary=" + salary + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                '}';
    }


}
