package cisco;

import java.util.ArrayList;
import java.util.List;
/**
 * Create two thread run both 1-100, have a List as command Database.
        thread1 will add current number to List
        thread2 will remove number from list
 */

public class ProducerConsumer {

    private static boolean addFlag = true;
    private List<Integer> db = new ArrayList<>(100);
    private static final Object lock = new Object();

    public void add(int n){
        synchronized (lock){
             if (!addFlag) {
                try {
                    System.out.println("DB is Full!! ");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            db.add(n);
            System.out.println("Adding: "+n);
            addFlag = false;
            lock.notifyAll();
        }

    }
    public void remove(int n){
        synchronized (lock){
            if (addFlag) {
                try {
                    System.out.println("Nothing to remove");
                    lock.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("removing: "+db.get(n-1));
            addFlag = true;
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Runnable addTask = ()-> {
            for (int n = 1; n<=100; n++){
                pc.add(n);
            }
        };

        Runnable removeTask = ()-> {
            for (int n = 1; n<=100; n++){
                pc.remove(n);
            }
        };

        Thread t1 = new Thread(addTask);
        Thread t2 = new Thread(removeTask);
        t1.start();
        t2.start();
    }
}
