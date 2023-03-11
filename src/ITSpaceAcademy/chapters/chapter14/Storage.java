package ITSpaceAcademy.chapters.chapter14;

public class Storage<T> {
    Object[] objects = new Object[10];
    int size;

    public void add(T obj) {
        if (size == objects.length) {
            extend();
        }
        objects[size++] = obj;
    }

    private void extend() {

    }

    public T getByIndex(int index) {
        return (T) objects[index];
    }

    public static <K> void sgf(Storage<?> args) {

    }
}