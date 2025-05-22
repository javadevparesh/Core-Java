package Multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Automatic(Intrinsic) lock achieved by 'synchronized' keyword

public class LockExplicit {

	public static void main(String[] args) {

		BankAccountLock sbi = new BankAccountLock();

		Runnable task = new Runnable() {

			@Override
			public void run() {
				sbi.withdraw(50);
			}
		};

		Thread t1 = new Thread(task, "Thread 1");
		Thread t2 = new Thread(task, "Thread 2");
		t1.start();
		t2.start();
	}
}

class BankAccountLock {

	private int balance = 100;
	private final Lock lock = new ReentrantLock();	// Threads will access 'withdraw()' by this

	public void withdraw(int amount) {

		System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
		try {
			if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) { // To get lock, Will wait for 1000-miliSeconds
				if (balance >= amount) { 	// If 'true', will execute 'if block' else
											// If 'false' (lock doesn't become available) exception will be thrown
					try {
						System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawal");
						Thread.sleep(3000);
						balance -= amount;
						System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remainig balance: " + balance);
					} catch (Exception e) {
						Thread.currentThread().interrupt();
					}finally {
						lock.unlock();
					}
				} else {
					System.out.println(Thread.currentThread().getName() + " Insufficient balance.");
				}
			}else {
				System.out.println(Thread.currentThread().getName() + " Could not aquired the lock, will try latter");
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();	// You need to re-write/restore the state,
		}										// which was saying thread is interrupted, so that other states can know
												// that interrupt has happen (Good practice)
		

		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " proceeding with withdraw ");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= amount;
			System.out
					.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + " insufficient balance");
		}
	}
}
