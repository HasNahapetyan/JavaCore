package ITSpaceAcademy.homeworks.employee.model;

import java.util.Objects;

public class Company {
    private String id;
    private String name;
    private String address;
    private String phonNumber;
    private int employeeCount;

    public Company(String id, String name, String address, String phonNumber, int employeeCount) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phonNumber = phonNumber;
        this.employeeCount = employeeCount;
    }

    public Company() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return getEmployeeCount() == company.getEmployeeCount() && Objects.equals(getId(), company.getId()) && Objects.equals(getName(), company.getName()) && Objects.equals(getAddress(), company.getAddress()) && Objects.equals(getPhonNumber(), company.getPhonNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress(), getPhonNumber(), getEmployeeCount());
    }

    @Override
    public String toString() {
        return "ImmutableCompany{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phonNumber='" + phonNumber + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
