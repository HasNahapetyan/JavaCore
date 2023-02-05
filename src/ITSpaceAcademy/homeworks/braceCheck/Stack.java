package ITSpaceAcademy.homeworks.braceCheck;

public class Stack {
    private int arr[] = new int [10];
    private int size = 10;
    private int tos;

    Stack(){
        tos = -1;
    }

    void push(char item){
        if(tos == size-1){
            extend();
        }
        arr[++tos] = item;

    }
    private void extend() {
        int[] array1 = new int[size+10];
        for (int i = 0; i < size; i++) {
            array1[i] = arr[i];
        }
        arr = array1;
        size += 10;
    }
    int pop(){
        if(tos<0){
            System.err.println("Stack underflow,");
            return 0;
        }
        return arr[tos--];
    }
    int peek(){
        if(tos<0){
            System.err.println("Stack underflow,");
            return 0;
        }
        return arr[tos];
    }

    boolean isEmpty(){
        return tos == -1;
    }

}
