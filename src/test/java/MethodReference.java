import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MethodReference {

    public static int squareNumber(int i){
        return i*i;
    }

    public static void main(String[] args) {

        //static method reference
        Consumer<String> c1 = System.out::println;
        c1.accept("Input string ");
        Function<String, Integer> f1 = String::length;
        System.out.println(f1.apply("String length"));

        //instance method reference
        UnaryOperator<Integer> u1 = MethodReference::squareNumber;
        System.out.println(u1.apply(18));

        //streams

        int[] numbers = {1, 4,2,7,9, 12, 16};


        System.out.println(Arrays.toString(Arrays.stream(numbers).filter(i -> i > 2).toArray()));

    }
}
