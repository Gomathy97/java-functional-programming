package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersStreams {
	private static void printNumbersInList_Structural(List<Integer> nums) {
		for(int num : nums) {
			System.out.println(num);
		}
	}

	private static void printNumbersInList_Functional(List<Integer> nums){
		nums.stream() //nums converted as stream
				.forEach(System.out::println); //Method reference
	}

	private static boolean isEven(Integer num){
		return num % 2 == 0;
	}

	private static boolean isOdd(Integer num){
		return num % 2 == 1;
	}

	private static void printEvenNumbersInList_Functional(List<Integer> nums){
		nums.stream()
//				.filter(num -> (num % 2) == 0) //Using Lambda
				.filter(NumbersStreams::isEven)//Using Functional reference
				.forEach(System.out::println);
	}

	private static void printSquareEvenNumbersInList_Functional(List<Integer> nums){
		nums.stream()
				.filter(num -> num % 2 == 0)
				.map(num -> num * num) //Using Lambda
				.forEach(System.out::println);
	}

	private static void printCubeOddNumbersInList_Functional(List<Integer> nums){
		nums.stream()
				.filter(num -> num % 2 == 1)
				.map(num -> num * num * num) //Using Lambda
				.forEach(System.out::println);
	}

	private static void printOddNumbersInList_Functional(List<Integer> nums){
		nums.stream()
//				.filter(num -> (num % 2) == 1) //Using Lambda
				.filter(NumbersStreams::isOdd)//Using Functional reference
				.forEach(System.out::println);
	}

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2,3,1,2,3,5,6);

		//Printing in structural approach
		System.out.println("Printing in structural approach");
		printNumbersInList_Structural(nums);

		//Printing in functional approach
		System.out.println("Printing in functional approach");
		printNumbersInList_Functional(nums);

		//Printing only even in functional approach
		System.out.println("Printing only even in functional approach");
		printEvenNumbersInList_Functional(nums);

		//Printing only odd in functional approach
		System.out.println("Printing only odd in functional approach");
		printOddNumbersInList_Functional(nums);

		//Printing only squares of even in functional approach
		System.out.println("Printing only squares of even in functional approach");
		printSquareEvenNumbersInList_Functional(nums);

		//Printing only cubes of even in functional approach
		System.out.println("Printing only cubes of even in functional approach");
		printCubeOddNumbersInList_Functional(nums);

		//Print the sum of all numbers
		System.out.println("Print the sum of all numbers");
		int sum = nums.stream()
//				.reduce(0,  (num1, num2) -> num1 + num2);
				.reduce(0, Integer::sum); //Predefined Function
		System.out.println(sum);

		//Print the max of all numbers
		System.out.println("Print the max of all numbers");
		System.out.println(nums.stream()
				.reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b));

		//sum of squares of the nums
		System.out.println("Sum of squares of the nums");
		System.out.println(nums.stream()
				.map(num -> num * num)
//				.reduce(0, (n1, n2) -> n1 + n2));
				.reduce(0, Integer::sum));

		//sum of cubes of the nums
		System.out.println("Sum of cubes of the nums");
		System.out.println(nums.stream()
				.map(num -> num * num * num)
				.reduce(0, (n1, n2) -> n1 + n2));

		//sum of odd nums in the list
		System.out.println("sum of odd nums in the list");
		System.out.println(nums.stream()
				.filter(num -> num % 2 == 1)
				.reduce(0, (n1, n2) -> n1 + n2));

		//Print only distinct numbers
		System.out.println("Print only distinct numbers");
		nums.stream().distinct().forEach(System.out::println);

		//Print in sorted order
		System.out.println("Print only distinct numbers");
		nums.stream().sorted().forEach(System.out::println);

		//Convert List to another List of squares of nums
		System.out.println("Convert List to another List of squares of nums");
		System.out.println(nums.stream().map(num -> num * num).collect(Collectors.toList()));

		//Convert List to another List of evens of nums
		System.out.println("Convert List to another List of evens of nums");
		System.out.println(nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList()));
	}
}
