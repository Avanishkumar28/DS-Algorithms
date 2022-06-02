package multithreading;

public class TestClassLevelLocking {

    public static void main(String[] args) {
        ClassLevelLocking obj1 = new ClassLevelLocking();
        ClassLevelLocking obj2 = new ClassLevelLocking();

        Runnable task1 = () -> obj2.printGreeting();
        Runnable task2 = () -> obj1.printNumbersStatic();
        Runnable task3 = () -> obj1.printNumbersSync();
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        t1.start();
        t2.start();
        t3.start();
    }
}
