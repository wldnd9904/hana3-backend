import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ex66 {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("mango");
        fruits.add("strawberry");
        System.out.println(fruits.size());
        System.out.println(fruits);

        fruits.add(0, "lemon");
        System.out.println(fruits);

        fruits.remove(1);
        System.out.println(fruits);

        Collections.sort(fruits);
        System.out.println(fruits);

        fruits.sort(Collections.reverseOrder());
        System.out.println(fruits);

        fruits.set(1, "peach");
        System.out.println(fruits);

        Iterator<String> it = fruits.iterator();
        while (it.hasNext())
            System.out.println(it.next());


        fruits.clear();
        System.out.println(fruits);


    }
}
