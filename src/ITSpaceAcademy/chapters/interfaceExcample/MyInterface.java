package ITSpaceAcademy.chapters.interfaceExcample;

public interface MyInterface {
    void fun();
    default void fun1(){}
    static void fun3(){};
}
