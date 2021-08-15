package programming;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;


public class FunctionalInterfaces {
    /*
        FUNCTIONAL INTERFACE
        -> Has only one abstract method
        -> That is the functional descriptor

        -> Predicate - Takes one input and returns boolean
        -> BiPredicate - Takes 2 inputs of type T and U and returns True of False
        -> Function - processes the input and returns an output
        -> BiFunction - Takes 2 inputs of type T and U and returns an output of type R
        -> Consumer - processes the input and returns void
        -> BiConsumer - takes two argument of type T, U and returns void
        -> Supplier - no input return something
        -> BinaryOperator - Takes 2 inputs of type T and returns the output of type T
        -> UnaryOperator - Takes 1 input of Type T and returns an output of type T

        -> IntOperators -- Function that accepts int values as arguments
                        -- No generic type, primitive types used
            -> IntConsumer
            -> IntFunction
            -> IntPredicate
            -> IntSupplier
            -> IntToDoubleFunction
            -> IntToLongFunction
            -> IntUnaryOperator
            -> IntBinaryOperator

            //Simlarly for Long
    */


    private static void printSqSumEvenNum(List<Integer> nums){
        Predicate<Integer> isEvenNumber = num -> num %2 == 0; //validates the object and returns boolean
//        Predicate<Integer> isEvenNumber = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer % 2 == 0;
//            }
//        };

        //Function<return type, argument type>
        Function<Integer, Integer> squareNumber = num -> num * num; //Takes one arg produces a result
//        Function<Integer, Integer> squareNumber = new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer integer) {
//                return integer * integer;
//            }
//        };

        Consumer<Integer> printConsumer = System.out::println; // Consumes whatever it takes
//        Consumer<Integer> printConsumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        };

        nums.stream()
                .filter(isEvenNumber)
                .map(squareNumber)
                .forEach(printConsumer);
//                .filter(num -> num % 2 == 0)
//                .map(num -> num * num)
//                .forEach(System.out::println);

        Supplier<Integer> randIntSupplier = () -> { //Doesn't take any input but do return an output
            Random random = new Random();
            return random.nextInt(100);
        };
//        Supplier<Integer> randIntSupplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                Random random = new Random();
//                return random.nextInt(100);
//            }
//        };
        System.out.println("RandomIntegerSupplier -- " + randIntSupplier.get());
//        System.out.println("RandomIntegerSupplier -- " + randIntSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x; //Takes an Input of type Integer and processes and returns the same type
//        UnaryOperator<Integer> unaryOperator = new UnaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer) {
//                return 3 * integer;
//            }
//        }
        System.out.println("Unary Operator multiply by 3 " + unaryOperator.apply(10));
    }

    private static void biOperators(){
        BiPredicate<Integer, String> biPredicate = (x, y) -> (x % 2 == 0) && (y.length() % 2 == 0); //Takes 2 inputs of type T and U and returns True of False
//        BiPredicate<Integer, String> biPredicate = new BiPredicate<Integer, String>() {
//            @Override
//            public boolean test(Integer integer, String string) {
//                return (integer % 2 == 0) && (string.length() % 2 == 0);
//            }
//        };
        System.out.println("biPredicate " + biPredicate.test(10, "Hello"));

        BiFunction<Integer, String, Double> biFunction = (x, y) -> (x + y.length()) / 2.0; //Takes 2 inputs of type T and U and returns an output of type R
//        BiFunction<Integer, String, Double> biFunction = new BiFunction<Integer, String, Double>() {
//            @Override
//            public Double apply(Integer integer, String string) {
//                return ( integer + string.length() ) / 2.0 ;
//            }
//        };
        System.out.println("BiFunction print average " + biFunction.apply(10, "Hello"));

        System.out.println("biConsumer ");
        BiConsumer<Integer, String> biConsumer  = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        }; //Takes 2 inputs of type T and U and returns void
//        BiConsumer<Integer, String> biConsumer = new BiConsumer<Integer, String>() {
//            @Override
//            public void accept(Integer integer, String s) {
//                System.out.println(integer);
//                System.out.println(s);
//            }
//        };
        biConsumer.accept(10, "Gomathy");
    }

    private static void intOperators(){
        //IntUnaryOperator
        IntUnaryOperator intUnaryOperator = (x) -> x * 3;
        System.out.println("IntUnaryOperator multiple by 3 " + intUnaryOperator.applyAsInt(11));

        //IntToLongFunction
        IntToLongFunction intToLongFunction = (x) -> Integer.MAX_VALUE * Long.valueOf(x);
        System.out.println("IntToLongFunction Integer.MAX_VALUE * x " + intToLongFunction.applyAsLong(2));

        //IntSupplier
        IntSupplier intSupplier = () -> {
            try {
                return Class.forName("programming.FunctionalInterfaces").hashCode();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return -1;
        };
        System.out.println("IntSupplier - hashcode of the class " + intSupplier.getAsInt());

        //IntBinaryOperator
        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
        System.out.println("IntBinaryOperator 10 + 20 = " + intBinaryOperator.applyAsInt(10, 20));

        //IntToDoubleFunction
        IntToDoubleFunction intToDoubleFunction = x -> (x + x) / 3.0;
        System.out.println("IntToDoubleFunction (10 + 10) / 3 = " + intToDoubleFunction.applyAsDouble(10));

        //IntConsumer
        IntConsumer intConsumer = System.out::println;
        System.out.print("IntConsumer ");
        intConsumer.accept(10);

        //IntFunction
        IntFunction<Double> intFunction = x -> x / 3.0; //Takes an argument of type Int and returns an output of type R
        System.out.println(intFunction.apply(8));

        //IntPredicate
        IntPredicate intPredicate = (x) -> x % 2 == 0;
        System.out.println("IntPredicate - check whether the number is even " + intPredicate.test(20));
    }

    private static Integer printSumNums(List<Integer> nums){
        BinaryOperator<Integer> sum1 = Integer::sum; // (a, b) -> a + b

//        BinaryOperator<Integer> sum1 = new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                return integer + integer2;
//            }
//        };

        return nums.stream()
                .reduce(0, sum1);
    }

    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(10,21,13,11,32,43,25,16);

        //Squares of the even num in nums
        System.out.println("Squares of the even num in nums");
        printSqSumEvenNum(nums);

        //sum of all nums
        System.out.println("Sum of all nums");
        System.out.println(printSumNums(nums));

        //BiOperators
        System.out.println("BiOperators");
        biOperators();

        //IntOperators -- Function that accepts int values as arguments
        System.out.println("IntOperators");
        intOperators();

    }
}
