package multithreading;

public class TestObjectLocking {

    public static void main(String[] args) {
        ObjectLocking objectLocking = new ObjectLocking();
        Runnable task1 = () -> objectLocking.printGreeting();
        Runnable task2 = () -> objectLocking.printNums();
        Runnable task3 = () -> objectLocking.printNumsSync();
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        t1.start();
        t2.start();
        t3.start();
    }
}
