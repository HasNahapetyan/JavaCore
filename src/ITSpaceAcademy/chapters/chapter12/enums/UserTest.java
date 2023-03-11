package ITSpaceAcademy.chapters.chapter12.enums;

import java.util.Scanner;

public class UserTest {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        User user = new User();
        user.name = "Poxos";
        user.surname = "Poxosyan";
        user.language = Language.HY;

        Language[] languages = Language.values();
        System.out.println("choose language from list");

        for (Language language:
             languages) {
            System.out.println(language);
        }
        String strLanguage = scanner.nextLine();
        user.language = Language.valueOf(strLanguage);
        System.out.println("for " + user.name + " selected " + user.language);
    }
}
