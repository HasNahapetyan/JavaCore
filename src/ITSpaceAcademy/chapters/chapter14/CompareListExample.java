package ITSpaceAcademy.chapters.chapter14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareListExample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Name1", " Surname1", 5641));
        studentList.add(new Student("Name2", " Surname2", 4613));

        Collections.sort(studentList, new StudentAgeComparator());
        System.out.println(studentList);
        Collections.sort(studentList, new StudentNameComparator());
        System.out.println(studentList);

        Collections.sort(studentList, Comparator.comparing(Student::getSurname));

    }
}
