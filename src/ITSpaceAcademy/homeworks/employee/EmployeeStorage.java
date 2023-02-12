package ITSpaceAcademy.homeworks.employee;

import java.util.Objects;
import java.util.Scanner;

public class EmployeeStorage {
    private Employee[] employees = new Employee[10];
    private int size = 0;

    public void add(Employee employee) {
        if(size == employees.length){
            extend();
        }
        employees[size] = employee;
        size++;
    }

    private void extend() {
        Employee[] array1 = new Employee[size+10];
        for (int i = 0; i < size; i++) {
            array1[i] = employees[i];
        }
        employees = array1;
    }

    public Employee getByIndex(int index) {
        return (index>=0 && index<size) ? employees[index] : null;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(employees[i] + " ");
        }
    }

    public void deleteByIndex(int index) {
        if(index<0 || index > size-1) {
            System.out.println("deleteByIndex: wrong index");
            return;
        }
        for (int i = index; i < size-1; i++) {
            employees[i] = employees[i + 1];
        }
        size--;
    }

    public void set(int index, Employee value) {
        if(index<0 || index > size-1) {
            System.err.println("set: wrong index");
        }
        employees[index] = value;
    }

    public void add(int index, Employee value) {
        if (index < 0 || index > size-1) {
            System.out.println("add2: no such index");
            return;
        }
        if(size == employees.length){
            extend();
        }
        for (int i = size-1; i >= index; i--) {
            employees[i] = employees[i - 1];
        }
        employees[index] = value;
        size++;
    }

    public boolean exists(Employee value) {
        boolean b = false;
        for (int i = 0; i < size; i++) {
            if (employees[i] == value) {
                b = true;
                break;
            }
        }
        return b;
    }

    public int getIndexByValue(Employee value) {
        for (int i = 0; i < size; i++) {
            if (employees[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void searchEmployeesByCompany(String company) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if(employee.getCompany().equals(company)){
                System.out.println(employee);
            }
        }
    }

    public Employee getEmployeeByID(String id) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if(employee.getCompany().equals(id)){
                return employee;
            }
        }
        return null;
    }

    public void searchEmployeeBySalaryRange(Double left, Double rught) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if(employee.getSalary() >= left && employee.getSalary() <= rught){
                System.out.println(employee);
            }
        }
    }

    public String changeEmployeePositionById(String id) {
        Employee employee = getEmployeeByID(id);
        if (employee == null) {
            System.out.println("Employee with " + id + " id does not exist");
            return null;
        }else {
            return employee.getPosition();
        }
    }

    public void printOnlyActiveEmployees() {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if(employee.isActive()){
                System.out.println(employee);
            }
        }
    }

    public void inactiveEmployeeById(String id) {
        Employee employee = getEmployeeByID(id);
        if (employee == null) {
            System.out.println("Employee with " + id + " id does not exist");
        }else {
            employee.setActive(false);
        }
    }

    public void activateEmployeeById(String id) {
        Employee employee = getEmployeeByID(id);
        if (employee == null) {
            System.out.println("Employee with " + id + " id does not exist");
        }else {
            employee.setActive(true);
        }
    }
}
