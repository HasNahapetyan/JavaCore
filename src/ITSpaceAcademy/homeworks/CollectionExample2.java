package ITSpaceAcademy.homeworks;

import java.util.*;

public class CollectionExample2 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        inputFiveNamesAndPrintWithoutDuplicates();

        inputTenNamesAndPrintSorted();

    }

    private static void inputTenNamesAndPrintSorted() {
        System.out.println("Please input 10 names");
        String newNames = scanner.nextLine();
        String[] namesArr = newNames.split(",");
        Set<String> namesSorted = new TreeSet<>(Arrays.asList(namesArr).subList(0, 10));
        System.out.println(namesSorted);
    }

    private static void inputFiveNamesAndPrintWithoutDuplicates() {
        System.out.println("Please input 5 names");
        String newNames = scanner.nextLine();
        String[] namesArr = newNames.split(",");
        List<String> namesList = new ArrayList<>(Arrays.asList(namesArr).subList(0, 5));
        Set<String> namesSet = new LinkedHashSet<>(namesList);
        System.out.println(namesSet);
    }
}
