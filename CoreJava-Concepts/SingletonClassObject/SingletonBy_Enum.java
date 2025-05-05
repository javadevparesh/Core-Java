package SingletonClassObject;

public class SingletonBy_Enum {
	
	enum DBConnection{
		INSTANCE;
	}
	
	/*
	 * In 'ENUM' by default all constructors are private.
	 * So, by default only one object is created.
	 * Per JVM only one Snapshot of 'ENUM' is present.
	 * So, 'ENUM' are by default 'Singleton'.
	 * 
	 */
	
	
	
}
