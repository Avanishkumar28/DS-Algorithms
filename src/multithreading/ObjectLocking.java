package multithreading;

public class ObjectLocking {

    public synchronized void printGreeting(){
        try {
            for (int i = 0; i < 10; i++){
                System.out.println("Hello world.... its 2022");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printNumsSync(){
        try {
            for (int i = 0; i < 20; i++){
                System.out.println("Printing numbers in sync, num is: "+i);
                Thread.sleep(300);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printNums(){
        try {
            for (int i = 0; i < 20; i++){
                System.out.println("Current number is: "+i);
                Thread.sleep(300);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
