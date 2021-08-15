package programming;

import java.util.stream.IntStream;

public class StreamsInThreads{

    public static void main(String[] args){
        System.out.println("Runnable Structural");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<12; i++){
                    System.out.println(Thread.currentThread().getId() + " : " + i);
                }
            }
        };

        startThread(runnable);
        startThread(runnable);
        startThread(runnable);

        System.out.println("Runnable Functional");
        Runnable runnable1 = () -> {
            IntStream.rangeClosed(1, 12).peek(System.out::println);
        };

        startThread(runnable1);
        startThread(runnable1);
        startThread(runnable1);
    }

    private static void startThread(Runnable runnable1) {
        Thread thread1;
        thread1 = new Thread(runnable1);
        thread1.start();
    }
}
