package ITSpaceAcademy.homeworks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionExample1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> namesList = new ArrayList<>();
        namesList.add("Name1");
        namesList.add("Name2");
        namesList.add("Name3");
        namesList.add("Name4");
        namesList.add("Name5");



        if(contains(namesList)){
            System.out.println("Contains");
        }else{
            System.out.println("Does not contain");
        }

        deleteName(namesList);
        addByIndex(namesList);
    }



    private static boolean contains(List<String> namesList) {
        System.out.println("Please input the name that you want to check from list");
        String name = scanner.nextLine();
        return namesList.contains(name);
    }

    private static void deleteName(List<String> namesList) {
        System.out.println("Please input the name that you want to delete from list");
        String nameToDelete = scanner.nextLine();
        namesList.remove(nameToDelete);
        System.out.println("The name " + nameToDelete + " deleted");
        System.out.println(namesList);
    }

    private static void addByIndex(List<String> namesList) {
        System.out.println("Please input a name that you want to add");
        String name = scanner.nextLine();
        System.out.println("Please input index");
        int index = Integer.parseInt(scanner.nextLine());
        try{
            namesList.add(index, name);
        }catch (IndexOutOfBoundsException e){
            System.err.println("Wrong index. Please try again");
        }

//  or
//        if(index>-1 && index < namesList.size()){
//            namesList.add(index, name);
//        }else{
//            System.err.println("Wrong index. Please try again");
//        }

    }
}
