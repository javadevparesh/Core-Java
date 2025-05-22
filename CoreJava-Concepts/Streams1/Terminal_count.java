package Streams1;

import java.util.Arrays;
import java.util.List;

/*
 * 6. count()	==> Returns the count of element present in the stream.
 * 
 */

public class Terminal_count {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		
		long noOfValuesPresent = numbers.stream()
		.filter((Integer val)-> val >=3)
		.count();
		
		System.out.println(noOfValuesPresent);
		//Output 3
	}
}
