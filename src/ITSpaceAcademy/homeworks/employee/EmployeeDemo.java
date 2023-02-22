package ITSpaceAcademy.homeworks.employee;

import ITSpaceAcademy.homeworks.employee.model.Company;
import ITSpaceAcademy.homeworks.employee.model.Employee;
import ITSpaceAcademy.homeworks.employee.storage.CompanyStorage;
import ITSpaceAcademy.homeworks.employee.storage.EmployeeStorage;
import ITSpaceAcademy.homeworks.employee.util.DateUtil;

import javax.swing.plaf.IconUIResource;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

public class EmployeeDemo implements Commands {

    private static final EmployeeStorage EMPLOYEE_STORAGE = new EmployeeStorage();
    private static final CompanyStorage COMPANY_STORAGE = new CompanyStorage();

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        Company company = new Company("company001", "Company1", "Gyumru", "123456789",0);
        COMPANY_STORAGE.add(company);
        company.setEmployeeCount(3);
        EMPLOYEE_STORAGE.add(new Employee("Name1","Surname1", "a001", 100d, company,"junior", new Date(),
                DateUtil.stringToDate("01-01-2023")));
        EMPLOYEE_STORAGE.add(new Employee("Name2","Surname2", "a001", 1000d, company,"mid", new Date(),
                DateUtil.stringToDate("27-10-2000")));
        EMPLOYEE_STORAGE.add(new Employee("Name3","Surname3", "a001", 10000d, company,"senior",new Date(),
                DateUtil.stringToDate("21-05-2009")));


        boolean isRun = true;

        while(isRun){
            Commands.printCommands();

            String command = sc.nextLine();

            switch (command) {
                case EXIT :
                    isRun = false;
                    break;
                case ADD_EMPLOYEE :
                    addEmployee();
                    break;
                case ADD_COMPANY :
                    addCompany();
                    break;
                case PRINT_ALL_EMPLOYEE :
                    EMPLOYEE_STORAGE.print();
                    break;
                case SEARCH_EMPLOYEE_BY_EMPLOYEE_ID :
                    getById();
                    break;
                case SEARCH_EMPLOYEE_BY_COMPANY_ID :

                    searchEmployeeByCompanyName();
                    break;
                case SEARCH_EMPLOYEE_BY_SALARY_RANGE :
                    searchEmployeeBySalaryRange();
                    break;
                case CHANGE_EMPLOYEE_POSITION_BY_EMPLOYEE_ID :
                    changeEmployeePositionById();
                    break;
                case PRINT_ONLY_ACTIVE_EMPLOYEES :
                    EMPLOYEE_STORAGE.printOnlyActiveEmployees();
                    break;
                case INACTIVATE_EMPLOYEE_BY_EMPLOYEE_ID :
                    inactiveEmployeeById();
                    break;
                case ACTIVATE_EMPLOYEE_BY_EMPLOYEE_ID :
                    activateEmployeeById();
                    break;
                case PRINT_ALL_COMPANIES :
                    COMPANY_STORAGE.print();
                    break;
                default :
                    System.out.println("wrong command, please try again");
            }
        }

    }


    private static void addCompany() {
        System.out.println("Please input id, name, address, phonNumber");
        String companyDataStr = sc.nextLine();
        String[] companyData = companyDataStr.split(",");
        String companyId = companyData[0];
        Company companyById = COMPANY_STORAGE.getCompanyById(companyId);
        if (companyById == null) {
            Company company = new Company(companyId, companyData[1], companyData[2], companyData[3], 0);
            COMPANY_STORAGE.add(company);
            System.out.println("Company was added!");
        }else{
            System.out.println("Company with " + companyId + " is=d already exists!!!");
        }

    }

    private static void activateEmployeeById() {

        System.out.println("Please input id");
        String id = sc.next();
        Employee employee = EMPLOYEE_STORAGE.getEmployeeByID(id);
        if (employee == null) {
            System.out.println("Employee with " + id + " id does not exist");
        }else {
            employee.setActive(true);
        }
    }

    private static void inactiveEmployeeById() {
        System.out.println("Please input id");
        String id = sc.next();
        EMPLOYEE_STORAGE.inactiveEmployeeById(id);
    }

    private static void changeEmployeePositionById() {
        EMPLOYEE_STORAGE.print();
        System.out.println("Please input id");
        String id = sc.next();
        Employee employee = EMPLOYEE_STORAGE.getEmployeeByID(id);
        if (EMPLOYEE_STORAGE.getEmployeeByID(id) == null) {
            System.out.println("Employee with " + id + " id does not exist");
        }else {
            System.out.println("Please input new position");
            String position = sc.nextLine();
            employee.setPosition(position);
            EMPLOYEE_STORAGE.print();
        }

    }

    private static void searchEmployeeByCompanyName() {
        COMPANY_STORAGE.print();
        System.out.println("Please input company id");
        String companyId = sc.nextLine();
        Company companyById = COMPANY_STORAGE.getCompanyById(companyId);
        if (companyById != null) {
            EMPLOYEE_STORAGE.searchEmployeesByCompany(companyId);
        }else{
            System.out.println("Company does not exist!");
        }
    }

    private static void searchEmployeeBySalaryRange() {
        System.out.println("Please input salary range");
        Double min = Double.parseDouble(sc.next());
        Double max = Double.parseDouble(sc.next());
        if (min > max) {
            System.out.println("min must be less than max");
            return;
        }
        EMPLOYEE_STORAGE.searchEmployeeBySalaryRange(min,max);
    }

    private static void getById() {
        System.out.println("Please input id");
        String id = sc.nextLine();
        Employee employee = EMPLOYEE_STORAGE.getEmployeeByID(id);
        if (employee == null) {
            System.out.println("Employee with " + id + " id does not exist");
        }else {
            System.out.println(employee);
        }
    }

    private static void addEmployee() throws ParseException {
        if(COMPANY_STORAGE.getSize() == 0){
            System.out.println("Please add company first!");
            return;
        }
        COMPANY_STORAGE.print();
        System.out.println("please choose company id");
        String companyId = sc.nextLine();
        Company companyById = COMPANY_STORAGE.getCompanyById(companyId);
        if (companyById != null) {
            System.out.println("Please input name surname employeeID salary position dateOfBirthDay(15-02-2023)");
            String employeeDataStr = sc.nextLine();
            String[] employeeData = employeeDataStr.split(",");
            String id = employeeData[2];
            Employee employeeById = EMPLOYEE_STORAGE.getEmployeeByID(id);
            if (employeeById == null) {
                Employee employee = new Employee(employeeData[0],employeeData[1],id,Double.parseDouble(employeeData[3]),
                        companyById,employeeData[4],new Date(),DateUtil.stringToDate(employeeData[5]));
                EMPLOYEE_STORAGE.add(employee);
                companyById.setEmployeeCount(companyById.getEmployeeCount()+1);
                System.out.println("Employee was added");
            }else {
                System.out.println("Employee with " + id + " id already exists");
            }
        }else{
            System.out.println("Wrong company id! please try again");
        }

    }
}
