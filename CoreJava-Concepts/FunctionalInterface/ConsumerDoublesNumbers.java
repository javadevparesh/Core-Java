package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/* leta hai, deta kuchh nahi - Method takes parameter but doesn't return anything */
public class ConsumerDoublesNumbers {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(4,2,5,7,11,21,51);
		
		Consumer<List<Integer>> doubleNumbers = list -> {
			
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i)*2 + " ");
			}
		};
		doubleNumbers.accept(numbers);
	}
}
