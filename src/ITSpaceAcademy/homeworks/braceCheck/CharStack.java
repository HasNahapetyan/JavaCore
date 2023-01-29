package ITSpaceAcademy.homeworks.braceCheck;

public class CharStack {
    private char arr[] = new char [10];
    private int size = 10;
    private int tos;

    CharStack(){
        tos = -1;
    }

    void push(char item){
        if(tos == 9){
            extend();
        }
        else {
            arr[++tos] = item;
        }
    }
    private void extend() {
        char[] array1 = new char[size+10];
        for (int i = 0; i < size; i++) {
            array1[i] = arr[i];
        }
        arr = array1;
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
