package src.main.java.Concurrency.ParallelStream;

import java.util.Arrays;
import java.util.stream.Stream;

public class SimpleDemo {

    public static void main(String[] args) {
        //way 1
        Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream();
        Stream<Integer> paralleStream = stream.parallel();

        //way 2
        Stream<Integer> paralleStream2 = Arrays.asList(1,2,3,4,5,6).parallelStream();

        //isParallel()
        Boolean test = paralleStream.isParallel();

        //1 2 3 4 5 6
        Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .forEachOrdered(s -> System.out.print(s + " "));

    }
}
