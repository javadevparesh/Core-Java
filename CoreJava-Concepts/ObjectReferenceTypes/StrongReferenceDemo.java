package ObjectReferenceTypes;

public class StrongReferenceDemo {

	public static void main(String[] args) {
		
		MyObject myObj = new MyObject(); // Strong reference
		myObj.sayHello();

		// The object will stay in memory until there are no more strong references to it
		myObj = null; // Now eligible for garbage collection
		System.gc(); // Suggest GC
	}
}

class MyObject {
	void sayHello() {
		System.out.println("Hello from a strong reference!");
	}
}
