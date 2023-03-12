package ITSpaceAcademy.chapters.chapter14;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<Student> studentTreeSet = new TreeSet<>(Comparator.comparing(Student::getSurname));
        studentTreeSet.add(new Student("Name1", " Surname1", 5641));
        studentTreeSet.add(new Student("Name2", " Surname2", 4613));

    }
}
