package Streams1;

import java.util.Arrays;
import java.util.List;

/*
 * 9. noneMatch(Predicate<T> predicate)	==> Checks if not a single value in the stream match the given predicate
 * 		 and return the boolean.
 * 
 */

public class Terminal_noneMatch {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		
		boolean hasValueGreaterThanThree = numbers.stream()
		.noneMatch((Integer val)-> val>3);
		
		System.out.println(hasValueGreaterThanThree);
		//Output 'false'
	}
}
