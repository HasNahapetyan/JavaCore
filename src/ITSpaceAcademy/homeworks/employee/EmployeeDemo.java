package ITSpaceAcademy.homeworks.employee;

import java.util.Scanner;

public class EmployeeDemo {

    private static final EmployeeStorage storage = new EmployeeStorage();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRun = true;

        while(isRun){
            System.out.println("Please input 0 to exit");
            System.out.println("Please input 1 to add employee");
            System.out.println("Please input 2 to print all employee");
            System.out.println("Please input 3 to search employee by employee ID");
            System.out.println("Please input 4 to search employee by company name");

            System.out.println("Please input 5 for search employee by salary range");
            System.out.println("Please input 6 for change employee position by id");
            System.out.println("Please input 7 for print only active employees");
            System.out.println("Please input 8 for inactive employee by id");
            System.out.println("Please input 9 for activate employee by id");

            String command = sc.nextLine();

            switch (command) {
                case "0" -> isRun = false;
                case "1" -> addEmployee();
                case "2" -> storage.print();
                case "3" -> getById();
                case "4" -> {
                    searchEmployeeByCompanyName();
                }
                case "5" -> searchEmployeeBySalaryRange();
                case "6" -> {
                    changeEmployeePositionById();
                }
                case "7" -> storage.printOnlyActiveEmployees();
                case "8" -> {
                    inactiveEmployeeById();
                }
                case "9" -> {
                    activateEmployeeById();
                }
                default -> System.out.println("wrong command, please try again");
            }
        }

    }

    private static void activateEmployeeById() {
        System.out.println("Please input id");
        String empId = sc.next();
        storage.activateEmployeeById(empId);
    }

    private static void inactiveEmployeeById() {
        System.out.println("Please input id");
        String emplId = sc.next();
        storage.inactiveEmployeeById(emplId);
    }

    private static void changeEmployeePositionById() {
        System.out.println("Please input id");
        String id = sc.next();
        System.out.println("Please input new position");
        String position = sc.nextLine();
        System.out.println(storage.changeEmployeePositionById(id, position));
    }

    private static void searchEmployeeByCompanyName() {
        System.out.println("Please input company");
        String company = sc.nextLine();
        storage.searchEmployeesByCompany(company);
    }

    private static void searchEmployeeBySalaryRange() {
        System.out.println("Please input salary range");
        Double min = Double.parseDouble(sc.next());
        Double max = Double.parseDouble(sc.next());
        storage.searchEmployeeBySalaryRange(min,max);
    }

    private static void getById() {
        System.out.println("Please input id");
        String id = sc.nextLine();
        Employee employee = storage.getEmployeeByID(id);
        if (employee == null) {
            System.out.println("Employee with " + id + " id does not exist");
        }else {
            System.out.println(employee);
        }
    }

    private static void addEmployee() {
        System.out.println("Please input name surname employeeID salary company position");
        String employeeDataStr = sc.nextLine();
        String[] employeeData = employeeDataStr.split(",");
        String id = employeeData[2];
        Employee employeeById = storage.getEmployeeByID(id);
        if (employeeById == null) {
            Employee employee = new Employee(employeeData[0],employeeData[1],id,Double.parseDouble(employeeData[3]),
                    employeeData[4],employeeData[5]);
            storage.add(employee);
        }else {
            System.out.println("Employee with " + id + " id already exists");
        }
    }
}
