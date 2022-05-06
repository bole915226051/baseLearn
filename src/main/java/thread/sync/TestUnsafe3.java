package thread.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * 练习不安全的集合
 * <p>
 * 多个线程操作同一个不安全的集合,导致集合数据问题
 */
public class TestUnsafe3 {


    public static void main(String[] args) {
        List list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }
            ).start();
        }
        System.out.println(list.size());
    }
}
