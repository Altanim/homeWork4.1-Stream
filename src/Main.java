import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Stream<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)).stream();
        findMinMax(nums,
                Integer::compareTo,
                (n1,n2) -> System.out.printf("минимальное число: %s, максимальное число: %s%n", n1,n2));
        List<Integer> i = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        getIntegers((ArrayList<Integer>) i);
    }
    // Задача №1
    public static <T> void findMinMax(Stream<? extends T>stream,
                                      Comparator<?super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer
                                      ){
        List<T> arr = new ArrayList<>();
        T min, max;
        arr = stream
                .sorted(order)
                .collect(Collectors.toList());
        if(arr.size() != 0){
            min = arr.get(0);
            max = arr.get(arr.size() - 1);
            minMaxConsumer.accept(min,max);
            if (min == null && max == null) {
                minMaxConsumer.accept(null, null);
            }
        }
    }
    // Задача №2
    public static void getIntegers (List<Integer>i){
        List<Integer> n = i
                .stream()
                .filter(s ->(s%2==0))
                .toList();
        System.out.println("Всего целых чисел: " + n.size());
    }

}
