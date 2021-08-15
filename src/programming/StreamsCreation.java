package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsCreation {

    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //1. Stream created on the instances wrapper class //ReferencePipeline
        Stream<Integer> stream_1 = nums.stream();
        System.out.println("Sum = " + stream_1 + " " + stream_1.reduce(0, Integer::sum));

        //2. Stream created on the instances wrapper class //ReferencePipeline
        Stream<Integer> stream_2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Sum = " + stream_2 + " " + stream_2.reduce(0, Integer::sum));

        //3. Streams on primitive type //IntPipeline
        //Advantage Autoboxing not needed
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        IntStream stream_3 = Arrays.stream(arr);
        System.out.println("Sum = " + stream_3 + " " + stream_3.sum());

        //4. InBuilt Stream creations
        System.out.println("Sum = " + IntStream.range(1, 10).sum());
        System.out.println("Sum = " + IntStream.rangeClosed(1, 10).sum());

        //5. InfinteStream
            System.out.println("Iterate over a function (1 - 10 even numbers) and generate stream");
            System.out.println("Sum = " + IntStream.iterate(2, each -> each + 2).limit(10).peek(System.out::println).sum());

            System.out.println("Iterate and print the 1st 10 powers of 2");
            System.out.println("Sum = " + IntStream.iterate(2, each -> each * 2).limit(10).peek(System.out::println).sum());

        //Collect on primitive type
        //Box it and convert it into a list
        System.out.println("Collect on primitive type");
            System.out.println(IntStream.iterate(2, each -> each + 2).limit(10).boxed().collect(Collectors.toList()));
            System.out.println(IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList()));

    }
}
