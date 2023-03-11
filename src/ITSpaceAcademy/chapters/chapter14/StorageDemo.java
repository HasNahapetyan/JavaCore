package ITSpaceAcademy.chapters.chapter14;

import java.util.LinkedList;

public class StorageDemo {
    public static void main(String[] args) {

        Storage<Student> studentStorage = new Storage<>();
        Storage<Book> bookStorage = new Storage<>();
        Student student = new Student("name", "surname", 52);

        Book book =  new Book();
        studentStorage.add(student);
        bookStorage.add(book);

        Storage<String> namesStorage = new Storage<>();


        Storage<Integer> numbers = new Storage<>();
        numbers.add(4);

        
    }

    public static void gf(Storage<?> args) {
    }

}
