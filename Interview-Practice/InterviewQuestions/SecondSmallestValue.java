package InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecondSmallestValue {

	public static void main(String[] args) {
		System.out.print("Second  smallest: ");
		List<Integer> list = Arrays.asList(5, 3, 13, 19, 3, 17, 3, 11);
		int n = 2;	// Taking 'n' to avoid change the stream logic (for 3rd smallest n=3 and so on)
		Integer output = list.stream().distinct().sorted().skip(n - 1).findFirst().get();
		System.out.println(output);

		// Print all values that starts with “p”:
		List<String> names = Arrays.asList("praneeth", "String", "Paresh", "Sarah", "paul", "Jon", "Gina");
		List<String> filteredNames = names.stream().filter(name -> name.toLowerCase().startsWith("p"))
				.collect(Collectors.toList());

		System.out.println(filteredNames);

	}
}
