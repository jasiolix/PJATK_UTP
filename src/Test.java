import java.util.*;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.stream().filter(lambda).forEach(System.out::println);
    }
    private static final Predicate<Integer> lambda = i -> i%2==0;
    private static Predicate<? super List<? super String>> method (){
        return obj -> obj.get(5)==null;
    }

}
