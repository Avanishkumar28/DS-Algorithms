package cisco;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenThread {

    private static final Object lock = new Object();
    private static boolean odd = true;

    private void printEvenMsg(int n) {
        synchronized (lock){
            if (odd){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String msg = new StringBuilder(" Even Thread - ")
                    .append("current at: ")
                    .append(n)
                    .toString();
            System.out.println(msg);
            odd = true;
            lock.notify();
        }
    }
    private void printOddMsg(int n) {
        synchronized (lock){
            if (!odd){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String msg = new StringBuilder(" Odd Thread - ")
                    .append("current: ")
                    .append(n)
                    .toString();
            System.out.println(msg);
            odd = false;
            lock.notify();
        }

    }

    public static void main(String[] args) {
        OddEvenThread oeThread = new OddEvenThread();
        Runnable evenTask = () -> {
            for (int n = 2; n <= 100; n += 2){
                oeThread.printEvenMsg(n);
            }
        };

        Runnable oddTask = () -> {
            for (int n = 1; n <= 100; n += 2){
                oeThread.printOddMsg(n);
            }
        };

        Thread evenThread = new Thread(evenTask);
        Thread oddThread = new Thread(oddTask);
        evenThread.start();
        oddThread.start();
    }
}
