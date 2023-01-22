package ITSpaceAcademy.homework.homework8;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray darr = new DynamicArray();
        for (int i = 0; i < 10; i++) {
            darr.add(i);
        }
        darr.print();
        System.out.println();
        darr.add(10);
        darr.print();
        System.out.println();
        System.out.println(darr.getByIndex(9));

        darr.deleteByIndex(4);
        darr.print();
        System.out.println();

        darr.add(4,4);
        darr.print();
        System.out.println();

        System.out.println(darr.exists(11));

        System.out.println(darr.getIndexByValue(11));
    }
}
