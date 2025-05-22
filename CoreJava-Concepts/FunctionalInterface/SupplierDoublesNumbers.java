package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDoublesNumbers {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(9,7,5,3,1);
		
		Supplier<List<Integer>> numbers = ()-> {
			for(int i=0; i<list.size(); i++) {
				list.set(i, list.get(i)*2);
			}
			return list;
		};
		System.out.println(numbers.get());
	}
}
