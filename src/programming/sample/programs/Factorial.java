package programming.sample.programs;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Factorial {
    public static void main(String[] args){
        System.out.println("Factorial of 1-10 numbers " + IntStream.rangeClosed(1, 10).reduce(1, (a, b) -> a * b));
        System.out.println("Factorial of 1-20 numbers " + LongStream.rangeClosed(1, 20).reduce(1l, (a, b) -> a * b));
        System.out.println("Factorial of 1-50 numbers " + LongStream.rangeClosed(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
    }
}
