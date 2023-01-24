package ITSpaceAcademy.homeworks.homework8;

public class DynamicArray {
    private int[] array = new int[10];
    private int size = 0;

    public void add(int value) {
        if(size == array.length){
            extend();
        }
        array[size] = value;
        size++;
    }

    private void extend() {
        int[] array1 = new int[size+10];
        for (int i = 0; i < size; i++) {
            array1[i] = array[i];
        }
        array = array1;
    }

    public int getByIndex(int index) {
        return (index>=0 && index<size) ? array[index] : -1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void deleteByIndex(int index) {
        if(index>=0 && index < size) {
            for (int i = index; i < size-1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    public void set(int index, int value) {
        if(index>=0 && index < size) {
            array[index] = value;
            return;
        }
        System.err.println("set: index is out of bounds");
    }

    public void add(int index, int value) {
        if (index < 0 && index >= size) {
            System.out.println("add2: no such index");
            return;
        }
        if(size == array.length){
            extend();
        }
        for (int i = size-1; i >= index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    public boolean exists(int value) {
        boolean b = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                b = true;
                break;
            }
        }
        return b;
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
