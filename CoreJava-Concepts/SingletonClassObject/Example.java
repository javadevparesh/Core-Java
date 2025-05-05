package SingletonClassObject;

class Singleton {

		// Step 2: Private static instance variable
	    private static Singleton instance;

	    // Step 1: Private constructor
	    private Singleton() { 
	        System.out.println("Singleton Instance Created");
	    }

	    // Step 3: Public static method for global access
	    public static synchronized Singleton getInstance() { // Step 4: Thread-Safety
	        if (instance == null) {
	            instance = new Singleton();
	        }
	        return instance;
	    }

	    // Step 5: Prevent Cloning
	    @Override
	    protected Object clone() throws CloneNotSupportedException {
	        throw new CloneNotSupportedException("Cloning of Singleton is not allowed");
	    }
	}

	// Usage
	public class Example {
	    public static void main(String[] args) {
	        Singleton obj1 = Singleton.getInstance();
	        Singleton obj2 = Singleton.getInstance();
	        
	        System.out.println(obj1 == obj2); // Outputs: true (Same instance)
	    }
	}
	
	
	/* CREATE SINGLETON CLASS in Java
	 * 
	 * 1. Make the constructor private
	 * 		- Prevents instantiation from outside the class.
	 * 
	 * 2. Create a private static instance of the class
	 * 		- Holds the one and only instance.
	 * 
	 * 3. Provide a public static method (usually getInstance())
	 * 		- Gives global access to the instance.
	 * 
	 */
