package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 练习Lock锁
 */
public class TestLock {

    public static void main(String[] args) {
        TestLock2 testlock2 = new TestLock2();
        new Thread(testlock2, "A").start();
        new Thread(testlock2, "B").start();
        new Thread(testlock2, "C").start();
    }
}

class TestLock2 implements Runnable {
    private int sum = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (sum <= 0) {
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-->" + sum--);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}
