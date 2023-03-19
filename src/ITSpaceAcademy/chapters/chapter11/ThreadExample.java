package ITSpaceAcademy.chapters.chapter11;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(thread.getThreadGroup());
        thread.setName("ddm");

        Thread mt = new Thread(new MyThread(),"MyThread");
        mt.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            System.out.println(mt.isAlive());


            try {
                //wait(1000);
                //notify();
                mt.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mt = new Thread(new MyThread());
        mt.start();

    }
}
