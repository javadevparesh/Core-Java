package Multithreading;

public class ThreadInterrupt extends Thread {

	@Override
	public void run() {

		try {
			Thread.sleep(1000);
			System.out.println("Thread is running....");
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted: " + e);
		}
	}

	public static void main(String[] args) {

		ThreadInterrupt t1 = new ThreadInterrupt();
		t1.start();
		t1.interrupt();	// On whatever method you are calling, the same you are telling that whatever your are doing,
						// stop it there.(like waiting, sleeping etc.)
	}
}
