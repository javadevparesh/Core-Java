package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* Run the program, each thread is getting Lock randomly. It should be as per the order of access */
// thread1, thread2 and then thread3 (Should be First come first)

/* Thread which is not getting time at all is called 'STARVATION' */

/* Synchronized disadvantages: NoFairness, IndefiniteBlocking, NoInterruptability, Read-Write locking(blocks both) */

public class LockFairnessExample {
	
	private final Lock lock = new ReentrantLock(true); // Fairness is true now, In order of the request lock will be acquired
													   // Its quite possible 'threa3' request for lock before 'thread1'	 
													   // It depends on scheduling of thread
	public static void main(String[] args) {
		LockFairnessExample example = new LockFairnessExample();
		
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				example.accessResource();
			}
		};
		
		Thread thread1 = new Thread(task, "Thread 1");
		Thread thread2 = new Thread(task, "Thread 2");
		Thread thread3 = new Thread(task, "Thread 3");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	
	
	public void accessResource() {
		lock.lock();	// Locking the method 'accessResource'
		try {
			System.out.println(Thread.currentThread().getName() + " acquired the lock.");
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			System.out.println(Thread.currentThread().getName() + " released the lock.");
			lock.unlock();
		}
	}
}


