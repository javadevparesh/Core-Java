package Multithreading;

//Driver class
public class ThreadSyncByBlock {

	public static void main(String[] args) {

		CounterSyncByBlock counter = new CounterSyncByBlock();
		SyncByBlock T1 = new SyncByBlock(counter); // Sharing 'counter' object between 3 synced by block threads
		SyncByBlock T2 = new SyncByBlock(counter);
		SyncByBlock T3 = new SyncByBlock(counter);
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
		System.out.println("Synchronized By Block: " + counter.getCount());
	}
}

//CounterSyncByBlock class
class CounterSyncByBlock {

	private int count = 0;

	public int getCount() {
		return count;
	}

	// Synchronizing the block
	public void incrementBySyncBlock() {
		synchronized(this) {	// Makes 'count' thread safe 
			count++;   // Block of code to sync (Critical Section) / Removed 'race condition', so got 'Mutual exclusion'
		}
	}
}

//SyncByBlock class
class SyncByBlock extends Thread {

	private CounterSyncByBlock counter;

	public SyncByBlock(CounterSyncByBlock counter) { // Getting 'CounterSyncByBlock' reference from main method (see new SyncByBlock()),   
		this.counter = counter;						 
	}

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			counter.incrementBySyncBlock();
		}
	}
}
