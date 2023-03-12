package ITSpaceAcademy.chapters.chapter8;


import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class TringSomething{
    int i;
}



// A simple example of inheritance.
// Create a superclass.
public abstract class A {
    int i, j;

    public A() {
        Object[] f = {5, "hello", new Object()};
        System.out.println("bjb");
    }

    void showij () {
        System.out.println("i and j: "+i+" " + j);
    }
}

// Create a subclass by extending class A. class B extends A
class B extends A implements Comparable, Comparator{
    int k;

    public B() {
        super.showij();
    }

    @Override
    void showij () {

        super.showij();
        System.out.println("i and j: "+i+" " + j);
    }

    void showk() {
        System.out.println("k: " + k);
    }

    void sum() {

        System.out.println("i+j+k: " + (1 + j + k));
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator thenComparing(Comparator other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public Comparator thenComparingInt(ToIntFunction keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator thenComparingLong(ToLongFunction keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator thenComparingDouble(ToDoubleFunction keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }

    @Override
    public Comparator thenComparing(Function keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator thenComparing(Function keyExtractor, Comparator keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }
}
class SimpleInheritance {
    public static void main(String args[]) {









        //A superob = new A();
        B subob = new B();


// The superclass may be used by itself.
//        superob.i = 10;
//        superob.j = 20;
//        System.out.println("Contents of superOb: ");
//        superob.showij();
        System.out.println();

// The subclass has access to all public members of its superclass.
        subob.i = 7;
        subob.j = 8;
        subob.k = 9;
        subob.showij();
        subob.showk();
        System.out.println("Contents of sub0b: ");
        subob.showij();
        subob.showk();
        System.out.println();
        System.out.println("Sum of i, j and k in sub0b:");
        subob.sum();



        int[] ar = new int[]{2222,2,2,2,0};
        function(ar);
        System.out.println(ar[1]);

    }
    static void function(int[] arr){
        arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
    }
}



