package Multithreading;

public class ThreadPriority extends Thread{
	
	public ThreadPriority(String name) {
		super(name);
	}

	@Override
	public void run() {
		
		for(int i=0; i<5; i++) {
			
			for(int j=0; j<100000000; j++) {
				
			}
			
			System.out.println(Thread.currentThread().getName() + " -priority: " + Thread.currentThread().getPriority() + "- count: " + i);
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		ThreadPriority low = new  ThreadPriority("Low Priority Thred");
		ThreadPriority medium = new  ThreadPriority("Medium Priority Thread");
		ThreadPriority high = new  ThreadPriority("High Proprity Thread");
		
		low.setPriority(Thread.MIN_PRIORITY);
		medium.setPriority(Thread.NORM_PRIORITY);
		high.setPriority(Thread.MAX_PRIORITY);

		low.start();
		medium.start();
		high.start();
	}
	
}
