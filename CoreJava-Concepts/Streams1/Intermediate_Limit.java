package Streams1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Intermediate_Limit {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,1,3,4,6);
		Stream<Integer> numberStream = numbers.stream().limit(3);
		
		List<Integer> numberList = numberStream.collect(Collectors.toList());
		
		numberList.forEach(number->System.out.print(number + " "));
	}
}
