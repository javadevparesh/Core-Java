package Multithreading;

/* 	::Conditions for DeadLock::
 * 
 * 1. Mutual Exclusion: Only one thread can access a resource at a time 
 * 2. Hold and Wait: A thread holding at least one resource is waiting to acquire additional resource held by other thread
 * 3. No Preemption: Resource cannot be forcibly taken from threads holding them
 * 4. Circular wait: A set of threads is waiting for each other in a circular chain
 * 
 */

public class DeadLockExample {
	
	public static void main(String[] args) {
		Pen pen = new Pen();
		Paper paper = new Paper();
		
		Thread thread1 = new Thread(new Task1(pen, paper), "Thread-1");
		Thread thread2 = new Thread(new Task2(pen, paper), "Thread-2");
		
		thread1.start();
		thread2.start();
	}
}

class Task1 implements Runnable{
	
	private Pen pen;
	private Paper paper;
	
	public Task1(Pen pen, Paper paper) {
		this.pen = pen;
		this.paper = paper;
	}
	
	@Override
	public void run() {
		pen.writeWithPenAndPaper(paper);  // 'thread1' locks pen and tries to lock paper
	}
}

class Task2 implements Runnable{
	
	private Pen pen;
	private Paper paper;
	
	public Task2(Pen pen, Paper paper) {
		this.pen = pen;
		this.paper = paper;
	}
	
	@Override
	public void run() {
		paper.writeWithPaperAndPen(pen);  // 'thread2' locks paper and tries to lock pen
	}
}


/*
 * When method is declared with 'synchronized', means the method will acquire the 'intrinsic' lock of the object
 * the method belongs to.(here 'writeWithPenAndPaper()' will acquire lock of 'Pen')
 * 
 * */
class Pen{
	
	public synchronized void writeWithPenAndPaper(Paper paper) {
		System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to get paper");
		paper.finishWriting();
	}
	
	public synchronized void finishWriting() {
		System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
	}
}

class Paper{

	public synchronized void writeWithPaperAndPen(Pen pen) {
		System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying to get pen");
		pen.finishWriting();
	}
	
	public synchronized void finishWriting() {	
		System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
	}
}
