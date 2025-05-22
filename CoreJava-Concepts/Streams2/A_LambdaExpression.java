package Streams2;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class A_LambdaExpression {

	public static void main(String[] args) {

		/* Predicate (To check condition - true or false) */
		// 1.
		Predicate<Integer> isEven = n -> n % 2 == 0;
		boolean evenTest = isEven.test(2);
		System.out.println("1. Predicate.test(): " + evenTest);

		// 2.
		Predicate<String> startLetter = l -> l.startsWith("a");
		System.out.println("2. Predicate.test(): " + startLetter.test("Vishnu"));

		
		
		/* Function (Work for you) */
		// 1.
		Function<Integer, Integer> doubleIt = n -> n * 2;
		System.out.println("1. Function.apply(): " + doubleIt.apply(2));

		// 2.
		Function<Integer, Integer> doubleNum = n -> 2 * n;
		Function<Integer, Integer> tripleNum = n -> 3 * n;
		System.out.println("andThen: " + doubleNum.andThen(tripleNum).apply(2));
		System.out.println("andThen: " + tripleNum.andThen(doubleNum).apply(2)); // same
		System.out.println("compose: " + doubleNum.compose(tripleNum).apply(2)); // same
		Function<Integer, Integer> identity = Function.identity(); // Whatever input same o/p, Used in String
		Integer res2 = identity.apply(5);
		System.out.println("identity: " + res2);

		
		
		/* Consumer */
		// 1.
		Consumer<Integer> print = x -> System.out.println("Consumer: " + x);
		print.accept(2);
		List<Integer> list = Arrays.asList(1, 2, 3);
		Consumer<List<Integer>> printList = x -> {
			for (int i : x) {
				System.out.println(i);
			}
		};
		printList.accept(list);

		/* Supplier */
		// 1.
		Supplier<String> giveHelloWorld = () -> "Hello World";
		System.out.println("Implicit return: " + giveHelloWorld.get());

		// 2.
		Supplier<String> stringSupplier = () -> {
		    String value = "Hello";
		    return value;  // <<== Here is the 'return'
		};
		System.out.println("Explicit return: " + stringSupplier.get());
		
		/* Combined Example for Predefined Interfaces */
		Predicate<Integer> predicate = x -> x % 2 == 0;
		Function<Integer, Integer> function = x -> x * x;
		Consumer<Integer> consumer = x -> System.out.println(x);
		Supplier<Integer> supplier = () -> 100;

		if (predicate.test(supplier.get())) {
			consumer.accept(function.apply(supplier.get()));
		}

		/* BiPredicate, BiConsumer, BiFunction */
		BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
		System.out.println(isSumEven.test(5, 5));

		BiConsumer<Integer, String> biConsumer = (x, y) -> {
			System.out.println(x);
			System.out.println(y);
		};

		BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
		System.out.println(biFunction.apply("a", "bc"));

		// UnaryOperator
		Function<Integer, Integer> f = x -> 2 * x;
		UnaryOperator<Integer> uf = x -> 2 * x;

		// BinaryOperator
		BinaryOperator<Integer> b = (x, y) -> x + y;

		// Method reference --> Use method without invoking & in place of Lambda
		// Expression
		List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");
		students.forEach(x -> System.out.println(x)); // invoking 'println' method
		students.forEach(System.out::println); // referenced 'println' method

		// Constructor reference
		List<String> names = Arrays.asList("A", "B", "C");
		List<MobilePhone> mobilePhoneList = names.stream().map(x -> new MobilePhone(x)).collect(Collectors.toList());
		List<MobilePhone> mobilePhoneList2 = names.stream().map(MobilePhone::new).collect(Collectors.toList());
		

	}

	public A_LambdaExpression() {
		super();
	}
}

class MobilePhone {
	String name;

	public MobilePhone(String name) {
		this.name = name;
	}

}