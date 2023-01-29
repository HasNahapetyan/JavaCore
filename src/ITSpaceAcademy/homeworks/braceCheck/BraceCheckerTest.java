package ITSpaceAcademy.homeworks.braceCheck;

public class BraceCheckerTest {
    public static void main(String[] args) {
        BraceChecker bc = new BraceChecker("gnsbdbmfj][ 9h9y<(0{[({YU}) Dth]}]");
        System.out.println( bc.check());

        BraceChecker bc2 = new BraceChecker("((}[](");
        System.out.println( bc2.check());

        BraceChecker bc3 = new BraceChecker("({{{{{[[[[[[((((((((((((");
        System.out.println( bc3.check());

        BraceChecker bc4 = new BraceChecker("}}}");
        System.out.println( bc4.check());

        BraceChecker bc5 = new BraceChecker("({[()]}(){[]})");
        System.out.println( bc5.check());




    }
}
