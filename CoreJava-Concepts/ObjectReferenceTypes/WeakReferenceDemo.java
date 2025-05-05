package ObjectReferenceTypes;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {

	public static void main(String[] args) {
		
		String strongRef = new String("Hello, Weak Reference!");
		WeakReference<String> weakRef = new WeakReference<>(strongRef);

		System.out.println("Before GC: " + weakRef.get());

		// Remove strong reference
		strongRef = null;

		// Request garbage collection
		System.gc();

		// Check if the object is still accessible
		System.out.println("After GC: " + weakRef.get());
	}
}
