package ITSpaceAcademy.chapters.chapter12;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationMain {

    @ExcampleAnnotation
    public void someMethod(){

    }

    @ExcampleAnnotation
    public void myMethod(){

    }
    public static void main(String[] args) {
        AnnotationMain annotationMain = new AnnotationMain();
        Method[] declaredMethods = annotationMain.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("method name is " + declaredMethod.getName());
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
                if(annotation instanceof ExcampleAnnotation){
                    System.out.println("our ExcampleAnnotation is present");
                }
            }
            //System.out.println(declaredMethod);
        }
    }
}
