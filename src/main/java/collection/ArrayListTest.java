package collection;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
//        List<String> arrayList = new ArrayList<>();
//        arrayList.add("str");
//
//        List<String> linkedList = new LinkedList<>();
//        linkedList.add("str");

        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String sb = iterator.next();
            if(sb.equals("aa")){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
