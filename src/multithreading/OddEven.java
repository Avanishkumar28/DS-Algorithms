package multithreading;

public class OddEven{

	static Runnable taskOne = OddEven::printEven;
	static Runnable taskTwo = OddEven::printOdd;
	static int i = 1;
	static Object lock = new Object();
	static boolean odd = true;
	
	public static void printEven(){
		while(i < 100){
			synchronized (lock){
				try{
					while(odd){
						lock.wait();
					}
					System.out.println(i);
					i++;
					odd = true;
				}catch (InterruptedException ie){
					ie.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					lock.notifyAll();
				}
			}
		}
		
	}
	
	public static void printOdd(){
		while(i < 100){
			synchronized (lock){
				try {
					while(!odd){
						lock.wait();
					}
					System.out.println(i);
					i++;
					odd = false;
					lock.notifyAll();
				}catch (InterruptedException ie){
					ie.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					lock.notifyAll();
				}
			}
		}
		
		
	}
	
	public static void main(String... s){
		Thread t1 = new Thread(taskOne);
		Thread t2 = new Thread(taskTwo);
		t1.start();
		t2.start();
	}
}