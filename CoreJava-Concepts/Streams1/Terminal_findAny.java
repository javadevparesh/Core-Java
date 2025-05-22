package Streams1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * 11. findAny()	==> Finds any random element element of the stream.
 * 
 */

public class Terminal_findAny {
	
	public static void main(String[] args) {	
		
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		
		Optional<Integer> anyValue = numbers.stream()
		.findAny();
		
		System.out.println(anyValue.get());
	}
}
