package ITSpaceAcademy.homeworks;

import java.util.*;

public class CollectionExample2 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        inputFiveNamesAndPrintWithoutDuplicates();

        inputTenNamesAndPrintSorted();

    }

    private static void inputTenNamesAndPrintSorted() {
        Set<String> namesSorted = new TreeSet<>();
        System.out.println("Please input 10 names");
        String newNames = scanner.nextLine();
        String[] namesArr = newNames.split(",");
        for (int i = 0; i < 10; i++) {
            namesSorted.add(namesArr[i]);
        }
        System.out.println(namesSorted);
    }

    private static void inputFiveNamesAndPrintWithoutDuplicates() {
        List<String> namesList = new ArrayList<>();
        System.out.println("Please input 5 names");
        String newNames = scanner.nextLine();
        String[] namesArr = newNames.split(",");
        for (int i = 0; i < 5; i++) {
            namesList.add(namesArr[i]);
        }
        Set<String> namesSet = new LinkedHashSet<>(namesList);
        System.out.println(namesSet);
    }
}
