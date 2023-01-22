package ITSpaceAcademy.homework.homework7;

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        double a1 = 9;
        double a2 = 6;
        System.out.println(c.sum(a1,a2));
        System.out.println(c.minus(a1,a2));
        System.out.println(c.mult(a1,a2));
        System.out.println(c.div(a1,a2));
    }
}
