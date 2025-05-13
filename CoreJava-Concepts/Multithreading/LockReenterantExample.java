package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockReenterantExample {
	
	private final Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		LockReenterantExample exmaple = new LockReenterantExample();
		exmaple.outerMethod();
	}
	
	public void outerMethod() {
		lock.lock();	// In Re-enterant lock 'counter' is maintained, how many times lock has been acquired?
		try {			// Lock will be released, When each lock is matched with it's unlock	 
				System.out.println("Outer Mehod");
				innerMethod();
		}finally {
			lock.unlock();
		}
	}
	
	public void innerMethod() {
		lock.lock();	// Since it's a Re-enterant lock, Can run again(re-enter the lock)
		try {
			System.out.println("Inner method");
		}finally {
			lock.unlock();
		}
	}
}
