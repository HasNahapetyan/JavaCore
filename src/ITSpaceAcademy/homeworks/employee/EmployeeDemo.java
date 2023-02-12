package ITSpaceAcademy.homeworks.employee;

import java.util.Scanner;

public class EmployeeDemo {

    private static EmployeeStorage storage = new EmployeeStorage();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        0 for exit (0 սեղմելու դեպքում ծրագիրը վերջանալու է)
        1 add employee (1 սեղմելու դեպքում ուզելու է բոլոր տվյալները աշխատակից սարքելու, ու սարքելու է իրա օբյեկտը ու քցի EmployeeStorage-ի մեջ)
        2 print all employee(տպելու է բոլոր աշխատակիցներին)
        3 search employee by employee ID (փնտրելու է աշխատակից իր իդ-ով)
        4 search employee by company name  (տալու ենք ընկերության անունը, տպի իրա բոլոր աշխատակիցներին)*/

        /*
        Please input 5 for search employee by salary range (ընտրելուց հետո երկու հատ double թիվ կուզեք կոնսոլով, ու իրանց միջակայքում գտնվող salary ունեցող employee-ներին կտպեք )
        Please input 6 for change employee position by id - իդ-ով աշխատակցի position-ը կփոխեք։
        Please input 7 for print only active employees (տպում եք այն աշխատակիցներին, ովքեր active=true)
        Please input 8 for inactive employee by id - ներմուծում ենք employeeID ու եթե կա էդ այդի ով աշխատակից, իրա active-ը դարձնում ենք false.
        Please input 9 for activate employee by id - ներմուծում ենք employeeID ու եթե կա էդ այդի ով աշխատակից ու իրա active=false, իրա active-ը դարձնում ենք true.
        */

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

            switch (command){
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addEmployee();
                    break;
                case "2":
                    storage.print();
                    break;
                case "3":
                    getById();
                    break;
                case "4":
                    System.out.println("Please input company");
                    String company = sc.nextLine();
                    storage.searchEmployeesByCompany(company);
                    break;
                case "5":
                    searchEmployeeBySalaryRange();
                    break;
                case "6":
                    System.out.println("Please input id");
                    String id = sc.next();
                    System.out.println(storage.changeEmployeePositionById(id));
                    break;
                case "7":
                    storage.printOnlyActiveEmployees();
                    break;
                case "8":
                    System.out.println("Please input id");
                    String emplId = sc.next();
                    storage.inactiveEmployeeById(emplId);
                    break;
                case "9":
                    System.out.println("Please input id");
                    String empId = sc.next();
                    storage.activateEmployeeById(empId);
                    break;
                default:
                    System.out.println("wrong command, please try again");
            }
        }

    }

    private static void searchEmployeeBySalaryRange() {
        System.out.println("Please input salary range");
        Double left = Double.parseDouble(sc.next());
        Double rught = Double.parseDouble(sc.next());
        storage.searchEmployeeBySalaryRange(left,rught);
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
