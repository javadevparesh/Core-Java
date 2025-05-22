package Streams1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 4. collect(Collector<T,A,R> collector)	==> Can be used to collect the elements of the stream into a list.
 * 
 */

public class Terminal_collect {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		
		numbers.stream()
		.filter((Integer val)-> val >=3)
		.collect(Collectors.toList());	
	}
}
