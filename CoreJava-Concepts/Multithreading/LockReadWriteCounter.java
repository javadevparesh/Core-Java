package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* 'ReentrantReadWriteLock' Allows multiple thread to read resources concurrently
	as long as no thread is writing to it. It ensures exclusive access for write operations
*/

// 'readLock' is available only when 'writeLock' hasn't acquired by any other thread.
// 'readLock' and 'writeLock' are related, Can communicate each-other.

public class LockReadWriteCounter {
	
	private int count = 0;
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();		
	private final Lock readLock = lock.readLock();
	
	private final Lock writeLock = lock.writeLock();
	
	
	public static void main(String[] args) throws Exception {
		
		LockReadWriteCounter counter = new LockReadWriteCounter();
		
		// Read operation
		Runnable readTask = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
				}
			}
		};
		
		//Write operation
		Runnable writeTask = new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					counter.increment();
					System.out.println(Thread.currentThread().getName() + " incremented");
				}
			}
		};
		
		Thread writeThread = new Thread(writeTask);
		Thread readThread1 = new Thread(readTask);
		Thread readThread2 = new Thread(readTask);
		
		writeThread.start();
		readThread1.start();
		readThread2.start();
		
		writeThread.join();
		readThread1.join();
		readThread2.join();
		
		System.out.println("Final count: " + counter.getCount());
	}
	
	
	public void increment() {
		
		writeLock.lock();
		try {
			count++;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}finally {
			writeLock.unlock();
		}
	}
	
	public int getCount() {
		readLock.lock();
		try {
			return count;
		}finally {
			readLock.unlock();
		}
	}
}
