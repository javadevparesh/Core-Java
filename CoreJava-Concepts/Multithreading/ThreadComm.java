package Multithreading;

public class ThreadComm {
	
	public static void main(String[] args) {
		
		SharedResource resource = new SharedResource();
		Thread producerThread = new Thread(new Producer(resource));
		Thread consumerThread = new Thread(new Consumer(resource));
		
		producerThread.start();
		consumerThread.start();
	}
}
/*
* 
* wait(): tells current thread to release lock and wait until other thread doesn't call 'notify()' or 'notifyAll()'
* notify(): wakes-up a single thread that is waiting.
* notifyAll(): wakes-up all threads that are waiting.
* 
*/
class SharedResource{
	
	private int data;
	private boolean hasData;
	
	public synchronized void produce(int value) { // We have locked on the object of class 'SharedResource'
		
		while(hasData) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();	// To restore its state
			}
		}
		data = value;
		hasData = true;
		System.out.println("Produced: " + value);
		notify(); // Notifying to Other thread, waiting for OR trying to lock/access, 
				  // the same object(we locked by synchronization above)  
				  /* If you have Only one 'Producer' and multiple 'Consumer' you can use notifyAll() */ 
	}
	
	public synchronized int consume() {
		
		while(!hasData) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();	// To restore its state
			}
		}
		hasData = false;
		System.out.println("Consumed: " + data);
		notify();
		return data;
	}
}

// Producer thread
class Producer implements Runnable{
	
	private SharedResource resource;
	
	public Producer(SharedResource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			resource.produce(i);
		}
	}
}

//Consumer thread
class Consumer implements Runnable{
	
	private SharedResource resource;
	
	public Consumer(SharedResource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			resource.consume();
		}
	}
}


