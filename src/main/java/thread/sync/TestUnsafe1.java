package thread.sync;

/**
 * 练习线程不安全1
 * 模拟抢票
 * <p>
 * 当多个线程,对同一对象进行操作时,线程是不安全的。
 */
public class TestUnsafe1 implements Runnable {

    private Integer sum = 10;

    // 1.创建一个线程
    @Override
    public void run() {
        while (sum >= 1) {
            getSum();
        }
    }

    public synchronized void getSum() {
        if (sum <= 0) {
            System.out.println("票已经抢光了");
            return;
        }
        //  模拟网络延迟
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢票,抢到第" + sum-- + "张" + ",还剩下" + sum);
    }

    public static void main(String[] args) {
        // 2.创建一个对象
        TestUnsafe1 unsafe = new TestUnsafe1();

        // 3.同时创建多个线程,对一个对象进行操作
        new Thread(unsafe, "小A").start();
        new Thread(unsafe, "小B").start();
        new Thread(unsafe, "小C").start();
    }


}

