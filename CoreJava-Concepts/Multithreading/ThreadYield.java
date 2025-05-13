package Multithreading;

public class ThreadYield extends Thread {

	public ThreadYield(String name) {
		super(name);
	}
	
	@Override
	public void run() {

		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName() + " is running");
//			Thread.yield();
		}
	}

	public static void main(String[] args) {

		ThreadYield t1 = new ThreadYield("t1");
		ThreadYield t2 = new ThreadYield("t2");
		t1.start();
		t2.start();
	}
}
