package Streams1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 1. Open stream using 'stream()' on collection
 * 2. apply intermediate operations
 * 3. apply termination operations
 * 
 */


public class WhyIntermediateOpsLazy {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		numbers.stream().filter((val)->val>3).peek((val)->System.out.println(val));

		// Intermediate operation: 'peek((val)->System.out.println(val));'  
		// will have no effect until Terminal operation is invoked.
		// 
		
		numbers.stream().filter((val)->val>3).peek((val)->System.out.print(val + " ")).collect(Collectors.toList());
		
		
	}
}
