package Streams1;

import java.util.Arrays;
import java.util.List;

/*
 * 8. allMatch(Predicate<T> predicate)	==> Checks if All of the values in the stream match the given predicate
 * 		 and return the boolean.
 * 
 */

public class Terminal_allMatch {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		
		boolean hasValueGreaterThanThree = numbers.stream()
		.allMatch((Integer val)-> val>3);
		
		System.out.println(hasValueGreaterThanThree);
		//Output 'false'
	}
}
