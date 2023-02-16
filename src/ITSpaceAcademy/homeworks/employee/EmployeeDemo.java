package ITSpaceAcademy.homeworks.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EmployeeDemo {

    private static final EmployeeStorage storage = new EmployeeStorage();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        storage.add(new Employee("Name1","Surname1", "a001", 100d, "company","junior",
                new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2023")));
        storage.add(new Employee("Name2","Surname2", "a001", 1000d, "company","mid",
                new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2023")));
        storage.add(new Employee("Name3","Surname3", "a001", 10000d, "company","senior",
                new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2023")));


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
                case "0" :
                    isRun = false;
                    break;
                case "1" :
                    addEmployee();
                    break;
                case "2" :
                    storage.print();
                    break;
                case "3" :
                    getById();
                    break;
                case "4" :
                    searchEmployeeByCompanyName();
                    break;
                case "5" :
                    searchEmployeeBySalaryRange();
                    break;
                case "6" :
                    changeEmployeePositionById();
                    break;
                case "7" :
                    storage.printOnlyActiveEmployees();
                    break;
                case "8" :
                    inactiveEmployeeById();
                    break;
                case "9" :
                    activateEmployeeById();
                    break;
                default :
                    System.out.println("wrong command, please try again");
            }
        }

    }

    private static void activateEmployeeById() {

        System.out.println("Please input id");
        String id = sc.next();
        Employee employee = storage.getEmployeeByID(id);
        if (employee == null) {
            System.out.println("Employee with " + id + " id does not exist");
        }else {
            employee.setActive(true);
        }
    }

    private static void inactiveEmployeeById() {
        System.out.println("Please input id");
        String id = sc.next();
        storage.inactiveEmployeeById(id);
    }

    private static void changeEmployeePositionById() {
        storage.print();
        System.out.println("Please input id");
        String id = sc.next();
        Employee employee = storage.getEmployeeByID(id);
        if (storage.getEmployeeByID(id) == null) {
            System.out.println("Employee with " + id + " id does not exist");
        }else {
            System.out.println("Please input new position");
            String position = sc.nextLine();
            employee.setPosition(position);
            storage.print();
        }

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
        if (min > max) {
            System.out.println("min must be less than max");
            return;
        }
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

    private static void addEmployee() throws ParseException {
        System.out.println("Please input name surname employeeID salary company position birthDate");
        String employeeDataStr = sc.nextLine();
        String[] employeeData = employeeDataStr.split(",");
        String id = employeeData[2];
        Employee employeeById = storage.getEmployeeByID(id);
        if (employeeById == null) {
            Employee employee = new Employee(employeeData[0],employeeData[1],id,Double.parseDouble(employeeData[3]),
                    employeeData[4],employeeData[5],new SimpleDateFormat("dd-MM-yyyy").parse(employeeData[6]));
            storage.add(employee);
        }else {
            System.out.println("Employee with " + id + " id already exists");
        }
    }
}
