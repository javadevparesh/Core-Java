package Multithreading;

// Driver class
public class ThreadSynchronization extends Thread {

	public static void main(String[] args) {

		Counter counter = new Counter();
		MyThreadNoSync T1 = new MyThreadNoSync(counter); // Sharing 'counter', non-sync object between 3 threads
		MyThreadNoSync T2 = new MyThreadNoSync(counter);
		MyThreadNoSync T3 = new MyThreadNoSync(counter);
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

		System.out.println("Non Synchronized: " + counter.getCount());
	}
}

// Counter class(Not synchronized)
class Counter {

	private int count = 0;
	public int getCount() {
		return count;
	}

	// Non-Synchroned method/Block
	public void increment() {
		count++;	// (Critical Section) - Race condition (Multiple threads working on shared resource)
	}
}

// MyThreadNoSync class
class MyThreadNoSync extends Thread {

	private Counter counter;
	public MyThreadNoSync(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			counter.increment();
		}
	}
}
