package Multithreading;

// Automatic(Intrinsic) lock achieved by 'synchronized' keyword

public class IntrinsicLock {

	public static void main(String[] args) {

		BankAccount bankAccount = new BankAccount();

		Runnable task = new Runnable() {

			@Override
			public void run() {
				bankAccount.withdraw(50);
			}
		};

		Thread t1 = new Thread(task, "Thread 1");
		Thread t2 = new Thread(task, "Thread 2");
		t1.start();
		t2.start();
	}
}

class BankAccount {

	private int balance = 100;

	public synchronized void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

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
