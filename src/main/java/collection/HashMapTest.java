package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("Test");
        hashSet.add("Test");

        for (String str : hashSet) {
            System.out.println("HashSet>" + str);
        }

        Set<String> set = new HashSet<String>();
        set.add("Test");
        set.add("Test");
        for (String str : hashSet) {
            System.out.println("Set>" + str);
        }

        Map<String,Object> hashMap = new HashMap<String,Object>(100000);
    }
}
