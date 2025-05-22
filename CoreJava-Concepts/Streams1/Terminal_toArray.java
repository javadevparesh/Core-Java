package Streams1;

import java.util.Arrays;
import java.util.List;

/*
 * 2. toArray(Consumer<T> action)	==> Collects the elements of the stream into an Array.
 * 
 */

public class Terminal_toArray {
		
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		
		Object[] filteredNumberArrType1 = numbers.stream()
		.filter((Integer val)-> val >=3)
		.toArray();
		
		for(Object obj : filteredNumberArrType1) {
			System.out.print(obj + " ");
		}
		
		
		Integer[] filteredNumberArrType2 = numbers.stream()
		.filter((Integer val)-> val >=3)
		.toArray((int size)-> new Integer[size]);
		
		System.out.println();
		for(Integer num : filteredNumberArrType2) {
			System.out.print(num + " ");
		}
	}
	
		
}
