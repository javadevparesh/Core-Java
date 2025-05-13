package Multithreading;

/* 'User' Threads - who are actually working 
 * 'Daemon' Threads - JVM will not wait for 
 * 
 */

public class ThreadSetDaemon extends Thread {

	@Override
	public void run() {

		while(true) {
			System.out.println("Hello World!");
		}
	}

	public static void main(String[] args) {

		ThreadSetDaemon myThread = new ThreadSetDaemon();
		myThread.setDaemon(true);
		myThread.start();	// 'main' thread's duty is over here
							// JVM will wait for 'User' thread to finish, which is running
							// JVM doesn't wait for 'Daemon' threads
		System.out.println("Main done.");
	}
}
