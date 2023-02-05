package ITSpaceAcademy.chapters.chapter8;


// A simple example of inheritance.
// Create a superclass.
public class A { int i, j;
    void showij () {
        System.out.println("i and j: "+i+" " + j);
    }
}

// Create a subclass by extending class A. class B extends A
class B extends A {
    int k;

    void showk() {
        System.out.println("k: " + k);
    }

    void sum() {

        System.out.println("i+j+k: " + (1 + j + k));
    }
}
class SimpleInheritance {
    public static void main(String args[]) {
        A superob = new A();
        B subob = new B();

// The superclass may be used by itself.
        superob.i = 10;
        superob.j = 20;
        System.out.println("Contents of superOb: ");
        superob.showij();
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
    }
}



