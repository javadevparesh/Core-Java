package Streams1;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(11,22,33,44,55,66,77,88,99,110);
		
		// Sequential processing
		long sequentialProcessingStartTime = System.currentTimeMillis();
		
		numbers.stream()
			.map((Integer val)-> val * val)
			.forEach((Integer val)-> System.out.println(val));
		System.out.println("Sequential processing time taken: " + (System.currentTimeMillis()-sequentialProcessingStartTime) + " millisecond");

		// Parallel processing
		long parallelProcessingStartTime = System.currentTimeMillis();
		
		numbers.parallelStream()
		.map((Integer val)-> val * val)
		.forEach((Integer val)-> System.out.println(val));
		System.out.println("Parallel processing time taken: " + (System.currentTimeMillis()-parallelProcessingStartTime) + " millisecond");
	}
}
