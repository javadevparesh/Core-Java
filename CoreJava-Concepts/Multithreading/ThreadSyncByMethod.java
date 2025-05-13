package Multithreading;

//Driver class
public class ThreadSyncByMethod {

	public static void main(String[] args) {

		CounterSyncByMethod counter = new CounterSyncByMethod();
		SyncByMethod T1 = new SyncByMethod(counter); // Sharing 'counter' object between 3 threads
		SyncByMethod T2 = new SyncByMethod(counter);
		SyncByMethod T3 = new SyncByMethod(counter);
		T1.start();
		T2.start();
		T3.start();

		try {
			T1.join();
			T2.join();
			T3.join();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Synchronized By Method: " + counter.getCount());
	}
}

//CounterSyncByMethod class
class CounterSyncByMethod {

	private int count = 0;
	public int getCount() {
		return count;
	}

	// Synchronizing the method
	public synchronized void incrementBySyncMethod() {
		count++;	// (Critical Section)
	}
}

//SyncByMethod class
class SyncByMethod extends Thread {

	private CounterSyncByMethod counter;
	public SyncByMethod(CounterSyncByMethod counter) {
		this.counter = counter;
	}

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			counter.incrementBySyncMethod();
		}
	}
}