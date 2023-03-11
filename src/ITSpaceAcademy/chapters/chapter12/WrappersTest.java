package ITSpaceAcademy.chapters.chapter12;

public class WrappersTest {
    public static void main(String[] args) {
        Short a = 400;
        foo(a);
        System.out.println(a);

        SomeClass sc = new SomeClass();

        foocsc(sc);
        System.out.println(sc);
    }

    private static void foocsc(SomeClass sc) {
        sc.d = 456d;
        sc.a = 95212;
    }

    private static void foo(Short a) {
        a = 5000;
    }
}
