package SingletonClassObject;

public class EagerIntialization {
	
	public static void main(String[] args) {
		
		EagerDBConnection conObject = EagerDBConnection.getInstance();
		
	}
	
}

class EagerDBConnection{
	
	private static EagerDBConnection conObject = new EagerDBConnection(); // Class level object(static)
	
	private EagerDBConnection() {	// Constructor is private
	}
	
	public static EagerDBConnection getInstance() {
		return conObject;
	}
}
