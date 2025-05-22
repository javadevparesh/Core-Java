package Streams1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WaysToCreateStreams {
	
	public static void main(String[] args) {
		
		/* Different ways to create stream */
		
		// 1. From Collection:
		List<Integer> salaryList = Arrays.asList(3000,4100,9000,1000,3500);
		
		// 2. From Array:
		Integer[] salaryArray = {3000,4100,9000,1000,3500};
		Stream<Integer> streamFromIntegerArray = Arrays.stream(salaryArray);
		
		// 3. From Static method:
		Stream<Integer> streamFromStaticMethod = Stream.of(1000,3500,4000,9000);
		
		// 4. From Stream Builder
		Stream.Builder<Integer> streamBuilder = Stream.builder();
		streamBuilder.add(1000).add(9000).add(3500);
		
		Stream<Integer> streamFromStreamBuilder = streamBuilder.build();
		
		// 5. From Stream Iterate
		Stream<Integer> streamFromIterate = Stream.iterate(1000, (Integer n) -> n + 5000).limit(5);
		
		
		
		/* Different intermediate Operations */
		
		/* We can chain multiple intermediate operations together to perform more complex processing
		   before applying operations to produce the result	 */
		
		
		// 1. filter(Predicate<T> predicate)		==> To filter the element
		
		// 2. map(Function<T,R> mapper)				==> To transform each element

		// 3. flatMap(Function<T,Stream<R> mapper)	==> To iterate over each element of the complex collection,
														// helps to flatten it.

		// 4. distinct()							==> Removes duplicate from the stream
		
		// 5. sorted()								==> Sorts the elements
		
		// 6. peek(Consumer<T> action)				==> Helps you to see the intermediate result of the stream which is getting processed
		
		// 7. limit(long maxSize)					==> Truncate the stream, to have no longer than given maxSize
		
		// 8. skip(long n)							==> Skip the first n elements of the stream
		
		// 9. mapToInt(ToIntFunction<T> mapper)		==> Helps to work with primitive "int" data types
		
		// 10. mapToLong(ToLongFunction<T> mapper)	==> Helps to work with primitive "long" data types

		// 11. mapToDouble(ToDoubleFunction<T> mapper)	==> Helps to work with primitive "double" data types

	}
}
