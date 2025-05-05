package ObjectReferenceTypes;

import java.lang.ref.SoftReference;

public class SoftRefereceDemo {

	public static void main(String[] args) {
		String strongRef = new String("Hello, Soft Reference!");
		SoftReference<String> softRef = new SoftReference<>(strongRef);

		System.out.println("Before GC: " + softRef.get());

		// Remove strong reference
		strongRef = null;

		// Request garbage collection
		System.gc();

		// Check if the object is still accessible
		System.out.println("After GC: " + softRef.get());
	}
}
