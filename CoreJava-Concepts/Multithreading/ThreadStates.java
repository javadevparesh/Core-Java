package Multithreading;

public class ThreadStates extends Thread{

	@Override
	public void run() {
		System.out.println("RUNNING");
		try {
			Thread.sleep(2000);
//			System.out.println(Thread.currentThread().getState());
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	
	public static void main(String[] args) throws InterruptedException {
		
		/* 'main' thread is executing following all statements ***/
		
		ThreadStates ts = new ThreadStates();	
		System.out.println(ts.getState());		// NEW
		ts.start();										 
		System.out.println(ts.getState());		
		Thread.sleep(100);					// 'main' thread sleep for 100ms (I want to give chance 'ts' to run)
		System.out.println(ts.getState());		// RUNNING
		ts.join();								// Asking 'main' thread to wait for 'ts' to finish
		System.out.println(ts.getState());		// TERMINATED
	}
	
}
