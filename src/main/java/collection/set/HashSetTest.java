package collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set set = new HashSet<Set>();
        set.add(new String("ABC"));
        set.add(new String("ABC"));
        set.add(new String("ABC"));
        set.add(new String("ABC"));
        System.out.println(set);
    }
}
