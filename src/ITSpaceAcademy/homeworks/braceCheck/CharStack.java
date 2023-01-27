package ITSpaceAcademy.homeworks.braceCheck;

public class CharStack {
    private char arr[] = new char [10];
    private int tos;

    CharStack(){
        tos = -1;
    }

    void push(char item){
        if(tos == 9){
            System.out.println("hmi kgrem");
        }
        else {
            arr[++tos] = item;
        }
    }

    char pop(){
        if(tos<0){
            System.err.println("CharStack underflow,");
            return 0;
        }
        return arr[tos--];
    }
    char peek(){
        if(tos<0){
            System.err.println("CharStack underflow,");
            return 0;
        }
        return arr[tos];
    }

    boolean isEmpty(){
        return tos == -1;
    }

}
