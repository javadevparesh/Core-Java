package Streams1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * 5. min(Comparator<T> comparator)	==> Finds the minimum or element from the stream,
 * 		based on the comparator provided
 * 
 * 	  max(Comparator<T> comparator)	==> Finds the maximum or element from the stream,
 * 		based on the comparator provided
 */

public class Terminal_min_max {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		
		Optional<Integer> minimumValueType1 = numbers.stream()
		.filter((Integer val)-> val>=3)
		.min((Integer val1, Integer val2)-> val1-val2);
		
		System.out.println(minimumValueType1.get());
		// Output 4

		Optional<Integer> minimumValueType2 = numbers.stream()
				.filter((Integer val)-> val>=3)
				.min((Integer val1, Integer val2)-> val2-val1);	// 'val2-val1' sorting in decreasing order
		
		System.out.println(minimumValueType2.get());
		// Output 10
	}
}
