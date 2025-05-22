package Streams1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * 10. findFirst(Predicate<T> predicate)	==> Finds the first element of the stream.
 * 
 */

public class Terminal_findFirst {
	
	public static void main(String[] args) {	
		
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		
		Optional<Integer> firstValue = numbers.stream()
		.filter((Integer val)-> val >=3)
		.findFirst();
		
		System.out.println(firstValue.get());
		//Output 4
	}
}
