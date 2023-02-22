package ITSpaceAcademy.homeworks.employee.storage;

import ITSpaceAcademy.homeworks.employee.model.Employee;

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
        if (size >= 0) System.arraycopy(employees, 0, array1, 0, size);
        employees = array1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i] + " ");
        }
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

    public void searchEmployeeBySalaryRange(Double min, Double max) {
        for (int i = 0; i < size; i++) {
            Double employeeSalary = employees[i].getSalary();
            if(employeeSalary >= min && employeeSalary <= max){
                System.out.println(employeeSalary);
            }
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

}
