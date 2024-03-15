import java.util.HashSet;
import java.util.Set;

public class ex67 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        boolean isAdded = set.add("hong");

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        setA.add(30);
        setA.add(40);
        setA.add(50);
        setA.add(60);
        setB.add(40);
        setB.add(30);
        setB.add(20);
        System.out.println(setA.add(70));
        System.out.println(setA.add(70));
        System.out.println(setA);
        System.out.println(setB);

        setA.retainAll(setB); // 교
        System.out.println(setA);

        setA.addAll(setB); // 합
        System.out.println(setA);

        setA.removeAll(setB);//차
        System.out.println(setA);

    }
}
