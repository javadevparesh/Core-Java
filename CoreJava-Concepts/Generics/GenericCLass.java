package Generics;

public class GenericCLass {
	
	public static void main(String[] args) {
		
		Print<Integer> printObj1 = new Print<Integer>();
		Print<String> printObj2 = new Print<String>();
		
		printObj1.setPrintValue(1);
		printObj2.setPrintValue("Paresh");
		
		int printValue = printObj1.getPrintValue();
		
		//we can't use printValue directly, we have to typecast it, else it will be compile time error
		// printValue if type of 'Object'
		
		/* 
		 * Yes, you can process Object, but only using methods from the Object class.
		 * To do more, you must cast it to its actual class after checking its type.
		 * 
		 */
		if(printValue == 1) {
			// do something
		}
		
		System.out.println(printObj2);
	}
}

class Print<T>{
	
	T value;
	
	
	public T getPrintValue() {
		return value;
	}
	public void setPrintValue(T value) {
		this.value = value;
	}
}

