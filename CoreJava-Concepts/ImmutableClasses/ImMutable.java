package ImmutableClasses;

import java.util.ArrayList;
import java.util.List;

final class myImMutableClass {

	/* State of an Immutable class cannot be changed */

	private final String name;
	private final List<Object> petNameList;
	
	// Constructor
	public myImMutableClass(String name, List<Object> petNameList) {
		this.name = name;
		this.petNameList = petNameList;
	}

	public String getName() {
		return name;
	}
	
	// Returning dip copy of list
	public List<Object> getPetNameList() {
		// This is required, because making list final.
		// means you cannot now point it to new list, but still can add, delete values
		// in it.
		// So, that's why we send the copy of it.

		return new ArrayList<>(petNameList); // Returning the copy
	}

	/* CREATE IMMUTABLE CLASS
	 * 
	 * 1. Make the class final 
	 * 		- Prevents sub-classing (which could break immutability).
	 * 
	 * 2. Make all fields private and final 
	 * 		- Prevents direct access and ensures fields can't be reassigned.
	 * 
	 * 3. Initialize all fields via constructor
	 * 
	 * 4. Do not provide any setters
	 * 
	 * 5. If the class contains mutable objects (like List, Date, custom classes): 
	 * 		- Perform deep copy in constructor and getter methods.(Return copies of mutable objects.)
	 * 
	 */
}

public class ImMutable {

	public static void main(String[] args) {
		List<Object> petNames = new ArrayList<>();
		petNames.add("sj");
		petNames.add("pj");

		myImMutableClass obj = new myImMutableClass("myName", petNames);
		obj.getPetNameList().add("hello");
		System.out.println(obj.getPetNameList());
	}
}
