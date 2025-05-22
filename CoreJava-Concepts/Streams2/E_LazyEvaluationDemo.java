package Streams2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E_LazyEvaluationDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        Stream<String> stream = names.stream()
                .filter(name -> {	// 'filter' operation is set up, but it does not run yet.
                    System.out.println("Filtering: " + name);
                    return name.length() > 3;	// is not applied until the terminal operation (collect) is invoked.
                });

        System.out.println("Before terminal operation");
        List<String> result = stream.collect(Collectors.toList());

        System.out.println("After terminal operation");
        System.out.println(result);
    }
}