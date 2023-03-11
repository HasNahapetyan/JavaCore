package ITSpaceAcademy.chapters.chapter14;

import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("name");
        names.add("name2");
        names.add("name3");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        for (String name:
             names) {
            System.out.println(name);
        }

    }
}
