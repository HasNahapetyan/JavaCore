package ITSpaceAcademy.chapters.chapter14.map;

import ITSpaceAcademy.chapters.chapter14.Student;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Student> studentMap = new HashMap<>();
        studentMap.put("mail", new Student("name", "surn", 951));
        studentMap.put("mail2", new Student("name2", "surn2", 531));

        Student student = studentMap.get("somekey");
        System.out.println(student);

        Person person = new Person("n", "sn");
        Person person2 = new Person("n2", "sn2");
        Map<ImmutableCompany, Integer> companySizeMap = new TreeMap<>(new Comparator<ImmutableCompany>() {
            @Override
            public int compare(ImmutableCompany o1, ImmutableCompany o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        ImmutableCompany immutableCompany = new ImmutableCompany("001", "CName1", person);
        ImmutableCompany immutableCompany2 = new ImmutableCompany("002", "CName2", person2);
        companySizeMap.put(immutableCompany,20);
        companySizeMap.put(immutableCompany2,4);

        System.out.println(companySizeMap.get(immutableCompany));

        Set<ImmutableCompany> companies = companySizeMap.keySet();

        Collection<Integer> values = companySizeMap.values();
        Set<Map.Entry<ImmutableCompany, Integer>> entries = companySizeMap.entrySet();

        for (Map.Entry<ImmutableCompany, Integer> entry :
                entries) {
            System.out.println(entry.getKey().getName() + "->" + entry.getValue());
        }

    }
}
