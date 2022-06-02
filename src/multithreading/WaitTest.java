package multithreading;

public class WaitTest {
    private static Object lock = new Object();
    //static  int n = 1;  // will be sheared by all the threads

    public static void methodOne(){
        synchronized (lock){
            int n = 1;
            while (n <= 10){
                System.out.println(Thread.currentThread().getName()+" n: "+n);
                if(n == 5) {
                    try {
                        System.out.println("Going in waiting . . . "+Thread.currentThread().getName());
                        lock.wait(2000);
                        System.out.println("Continue execution . . ."+Thread.currentThread().getName()+" from: n = "+n);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                n++;
            }
        }

        System.out.println("Execution Done! "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable task = WaitTest::methodOne;

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
