package ITSpaceAcademy.homeworks.homework7;

public class Calculator {
    double sum(double a, double b){
        return a+b;
    }
    double minus(double a, double b){
        return a-b;
    }
    double mult(double a, double b){
        return a*b;
    }
    double div(double a, double b){
        if(b==0){
            System.out.println("divided by 0");
            return -1;
        }
        return a/b;
    }
}
