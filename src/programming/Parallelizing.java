package programming;

import java.util.stream.LongStream;

public class Parallelizing {

    public static void main(String[] args){
        long time = System.currentTimeMillis();

        //Sequential Stream
        System.out.println(LongStream.rangeClosed(1, 100000000).sum());//5000000050000000
        System.out.println(System.currentTimeMillis() - time);//214

        time = System.currentTimeMillis();

        //Parallel Stream
        System.out.println(LongStream.rangeClosed(1, 100000000).parallel().sum());
        System.out.println(System.currentTimeMillis() - time);//24

    }
}
