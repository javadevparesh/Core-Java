package Streams1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Intermediate_FlatMap {
	
	public static void main(String[] args) {
		
		List<List<String>> sentenceList = Arrays.asList(
				Arrays.asList("I","LOVE","JAVA"),
				Arrays.asList("CONCEPTS","ARE","CLEAR"),
				Arrays.asList("ITS","VERY","EASY")
				);
		
		Stream<String> wordStream1 = sentenceList.stream().flatMap((List<String> sentence)-> sentence.stream());
			// Output: I, LOVE, JAVA, CONCEPTS, ARE, CLEAR, ITS, VERY, EASY
		
			wordStream1.forEach(word->System.out.print(word + " "));
		
		Stream<String> wordStream2 = sentenceList.stream()
		.flatMap((List<String> sentence)-> sentence.stream().map((String value)->value.toLowerCase()));
			// Output: i, love, java, concepts, are, clear, its, very, easy
			
			System.out.println();
			wordStream2.forEach(word->System.out.print(word + " "));
			//wordStream2.forEach(System.out::println);
		
	}
}
