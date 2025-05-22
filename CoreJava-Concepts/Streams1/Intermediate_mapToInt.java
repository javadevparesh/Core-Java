package Streams1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Intermediate_mapToInt {
	
	public static void main(String[] args) {
		
		List<String> numbers = Arrays.asList("2","1","4","7");
		IntStream numberStream = numbers.stream().mapToInt((String val)->Integer.parseInt(val));
		
		int[] numberArray = numberStream.toArray();
		for(int number : numberArray) {
			System.out.print(number + " ");
		}
		// Output 2, 1, 4, 7
		
		int[] numArray = {2,1,4,7};
		IntStream numStream = Arrays.stream(numArray);
		int[] filteredArray = numStream.filter((int val)-> val>2).toArray();
//		int[] filteredArray = numStream.toArray();
	
		System.out.println();
		for(int number : filteredArray) {
			System.out.print(number + " "); 
		}
		//Output 4, 7
	}
}
