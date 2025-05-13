package Multithreading;

/* 	::Conditions for DeadLock::
 * 
 * 1. Mutual Exclusion: Only one thread can access a resource at a time 
 * 2. Hold and Wait: A thread holding at least one resource is waiting to acquire additional resource held by other thread
 * 3. No Preemption: Resource cannot be forcibly taken from threads holding them
 * 4. Circular wait: A set of threads is waiting for each other in a circular chain
 * 
 */

public class DeadLockExampleResolve {
	
	public static void main(String[] args) {
		Pens pens = new Pens();
		Papers papers = new Papers();
		
		Thread thread1 = new Thread(new Tsk1(pens, papers), "Thread-1");
		Thread thread2 = new Thread(new Tsk2(pens, papers), "Thread-2");
		
		thread1.start();
		thread2.start();
	}
}

class Tsk1 implements Runnable{
	
	private Pens pens;
	private Papers papers;
	
	public Tsk1(Pens pens, Papers papers) {
		this.pens = pens;
		this.papers = papers;
	}
	
	@Override
	public void run() {
		pens.writeWithPenAndPaper(papers);  // 'thread1' locks pen and tries to lock paper
	}
}

class Tsk2 implements Runnable{
	
	private Pens pens;
	private Papers papers;
		
	public Tsk2(Pens pens, Papers papers) {
		this.pens = pens;
		this.papers = papers;
	}
	
	@Override
	public void run() {
		synchronized(pens) {
			papers.writeWithPaperAndPen(pens);  // 'thread2' locks paper and tries to lock pen
		}
	}
}


/*
 * When method is declared with 'synchronized', means the method will acquire the 'intrinsic' lock of the object
 * the method belongs to.(here 'writeWithPenAndPaper()' will acquire lock of 'Pen')
 * 
 * */
class Pens{
	
	public synchronized void writeWithPenAndPaper(Papers papers) {
		System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to get paper");
		papers.finishWriting();
	}
	
	public synchronized void finishWriting() {
		System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
	}
}

class Papers{

	public synchronized void writeWithPaperAndPen(Pens pens) {
		System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying to get pen");
		pens.finishWriting();
	}
	
	public synchronized void finishWriting() {	
		System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
	}
}
