package Streams1;

import java.util.Arrays;
import java.util.List;

public class TerminalOperations {
	
	public static void main(String[] args) {
		
		/* Different Terminal operations */
		
		// 1. forEach(Consumer<T> action):
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		
		numbers.stream()
			.filter((Integer val)-> val>=3)
			.forEach((Integer val)->System.out.println(val));
		
		//Output 4,7,10
		
		
		/* Different Terminal Operations */
		
		// 1. forEach(Consumer<T> action)	==> Perform action on each element of the Stream. DOESN'T return any value
		
		// 2. toArray						==> 
			
	}
}
