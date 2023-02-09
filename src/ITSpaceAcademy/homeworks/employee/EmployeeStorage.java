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

    public void findEmployeesByCompany(String company) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getCompany().equals(company)){
                System.out.println(employees[i]);
            }
        }
    }

    public void findEmployeeByID(String id) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getCompany().equals(id)){
                System.out.println(employees[i]);
                return;
            }
        }
        System.out.println("wrong ID");
    }

    public boolean idIsUnique(String id) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getCompany().equals(id)){
                System.out.println("this ID already exists");
                return false;
            }
        }
        return true;
    }
}
