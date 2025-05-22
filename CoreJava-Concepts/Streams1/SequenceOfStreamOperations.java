package Streams1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Generally each Element processed sequentially and can perform multiple operations,
 * this feature helps Stream to fast process the task.
 * 
 * For Example: If you need to return any number which is > 3,
 * process will stop at 4 itself. 
 * 
 * For 'Sorting' operation all elements should be present before it starts.
 * 
 * */
public class SequenceOfStreamOperations {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,1,4,7,10);
		Stream<Integer> numbersStream = numbers.stream()
		.filter((Integer val)-> val >= 3)
		.peek((Integer val)->System.out.println("After filter: " + val))	// I am seeing intermediate result here.
		.map((Integer val)-> (val *-1))
		.peek((Integer val)->System.out.println("After negating: " + val))	// I am seeing intermediate result here.
		.sorted()
		.peek((Integer val)->System.out.println("After sorted: " + val));	// I am seeing intermediate result here.
		
		numbersStream.collect(Collectors.toList());
	}
}
