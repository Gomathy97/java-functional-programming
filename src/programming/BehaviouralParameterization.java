package programming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaviouralParameterization {

    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(10,21,13,11,32,43,25,16);
        /*
            second parameter is the behaviour which is passed as argument
         */
//        Print only Even
        System.out.println("Print only Even");
        filterAndPrint(nums, num1 -> num1 % 2 == 0);

        //Print only Odd
        System.out.println("Print only Odd");
        filterAndPrint(nums, num -> num % 2 == 1);

        //Print only Multiples of 3
        System.out.println("Print only Multiples of 3");
        filterAndPrint(nums, num -> num % 3 == 0);

        //List of squares of nums
        System.out.println("List of squares of nums");
        mapAndPrint(nums, num1 -> num1 * num1);

        //List of cubes of num
        System.out.println("List of cubes of nums");
        mapAndPrint(nums, num -> num * num * num);

        //List of doubles of nums
        System.out.println("List of doubles of nums");
        mapAndPrint(nums, num -> num + num);
    }

    private static void mapAndPrint(List<Integer> nums, Function<Integer, Integer> function1) {
        System.out.println(nums.stream()
                .map(function1)
                .collect(Collectors.toList()));
    }

    private static void filterAndPrint(List<Integer> nums, Predicate<Integer> predicate) {
        nums.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
