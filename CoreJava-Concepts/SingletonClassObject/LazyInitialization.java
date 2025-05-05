package SingletonClassObject;

public class LazyInitialization {
	
	public static void main(String[] args) {
		
		LazyDBConnection lazyConObject = LazyDBConnection.getInstance();
	}
		
}

class LazyDBConnection {

	private static LazyDBConnection lazyConObject;	// Class level Object

	private LazyDBConnection() {
	}
	
	// sync method is slow. puts lock & then unlocks	
	synchronized public static LazyDBConnection getInstance() { 

		if (lazyConObject == null) { // If Object is null and 2 threads comes in parallel then issue, to resolve sync 
			lazyConObject = new LazyDBConnection();
		}
		return lazyConObject;
	}
}