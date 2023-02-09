package ITSpaceAcademy.homeworks.employee;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        /*
        0 for exit (0 սեղմելու դեպքում ծրագիրը վերջանալու է)
        1 add employee (1 սեղմելու դեպքում ուզելու է բոլոր տվյալները աշխատակից սարքելու, ու սարքելու է իրա օբյեկտը ու քցի EmployeeStorage-ի մեջ)
        2 print all employee(տպելու է բոլոր աշխատակիցներին)
        3 search employee by employee ID (փնտրելու է աշխատակից իր իդ-ով)
        4 search employee by company name  (տալու ենք ընկերության անունը, տպի իրա բոլոր աշխատակիցներին)*/

        EmployeeStorage storage = new EmployeeStorage();


        Scanner sc = new Scanner(System.in);
        boolean isRun = true;

        while(isRun){
            System.out.println("Please input 0 to exit");
            System.out.println("Please input 1 to add employee");
            System.out.println("Please input 2 to print all employee");
            System.out.println("Please input 3 to search employee by employee ID");
            System.out.println("Please input 4 to search employee by company name");
            String command = sc.nextLine();

            switch (command){
                case "0":
                    isRun = false;
                    break;
                case "1":
                    Employee employee = new Employee();
                    System.out.println("Please input name");
                    employee.setName(sc.nextLine());
                    System.out.println("Please input surname");
                    employee.setSurname(sc.nextLine());
                    while (true){
                        System.out.println("Please input employeeID");
                        String id = sc.nextLine();
                        if (storage.idIsUnique(id)) {
                            employee.setId(id);
                            break;
                        }
                    }
                    System.out.println("Please input salary");
                    employee.setSalary(sc.nextLine());
                    System.out.println("Please input company");
                    employee.setCompany(sc.nextLine());
                    System.out.println("Please input position");
                    employee.setPosition(sc.nextLine());
                    storage.add(employee);
                    break;
                case "2":
                    storage.print();
                    break;
                case "3":
                    System.out.println("Please input ID");
                    String ID = sc.nextLine();
                    storage.findEmployeeByID(ID);
                    break;
                case "4":
                    System.out.println("Please input company");
                    String company = sc.nextLine();
                    storage.findEmployeesByCompany(company);
                    break;
                default:
                    System.out.println("wrong command, please try again");
            }
        }


    }
}
