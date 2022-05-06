package thread;

/**
 * 通过实现Runnable接口,模拟抢票功能
 * <p>
 * 发现多个线程,共享同一个资源时,线程不安全,数据混乱,（并发问题）
 */
public class TestTicketRunnable implements Runnable {
    private int tick = 10;


    @Override
    public void run() {
        while (true) {
            if (tick <= 0) {
                break;
            }
            //  模拟抢票时间
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + (tick--) + "张票");
        }

    }

    public static void main(String[] args) {
        TestTicketRunnable testTicketRunnable = new TestTicketRunnable();
        new Thread(testTicketRunnable, "小红").start();
        new Thread(testTicketRunnable, "小张").start();
        new Thread(testTicketRunnable, "小李").start();
    }
}
