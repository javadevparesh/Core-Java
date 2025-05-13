package Multithreading;

/* The 'wait()' method in Java is used for inter-thread communication, 
   specifically 
   to pause the execution of the current thread until another thread notifies it. 
*/

/*
 * wait(), notify(), notifyAll() can only be called in synchronized context. (means only in Synchronized 'block' or 'method')
 * 
 * wait(): tells current thread to release lock and wait until other thread doesn't call 'notify()' or 'notifyAll()'
 * notify(): wakes-up a single thread that is waiting.
 * notifyAll(): wakes-up all threads that are waiting.
 * 
 */

public class ThreadCommunication extends Thread {

    enum Counts {
        ONE, TWO, THREE, FOUR, FIVE
    }

    private final Object lock;

    public ThreadCommunication(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        
    	synchronized (this) {
            for (Counts number : Counts.values()) {
                System.out.print(number + ": ");
                try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
                lock.notify();

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
      
    	Object lock = new Object();
        ThreadCommunication t1 = new ThreadCommunication(lock);
        t1.start();

        synchronized (lock) {
            for (int i = 1; i <= 5; i++) {
                lock.wait(); 				// Wait for the thread to print
                System.out.print(i);
                System.out.println();
                Thread.sleep(500);
                lock.notify(); 				// Wake the thread
            }
        }
        
        System.out.println("\nThis is \'wait() - notify()\' demo...");
    }
}
