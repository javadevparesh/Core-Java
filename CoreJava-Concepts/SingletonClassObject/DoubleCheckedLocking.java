package SingletonClassObject;

public class DoubleCheckedLocking {
	
	private static volatile DoubleCheckedLocking conObject;
	
	public DoubleCheckedLocking() {
	}
	
	
	public static DoubleCheckedLocking getInstance() {
		
		if(conObject == null) {
				synchronized (DoubleCheckedLocking.class) { /** lock is applied at the class level - This is Sync block **/	
					if(conObject == null) {				  		// Locks the class 'DatabaseConnection' so only one thread
						conObject = new DoubleCheckedLocking();	// at a time can execute the code inside the block	
					}
				}
		}
		return conObject;
	}
}
