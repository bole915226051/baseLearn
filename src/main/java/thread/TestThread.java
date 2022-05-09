package thread;

/**
 * 创建线程方式一,继承Thread类,重写run方法.调用start方法,开启线程
 * <p>
 * 总结:线程开启不一定立即执行,是由CPU调度执行。
 */
public class TestThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Thread..." + i);
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        //  启动一个新的线程
        testThread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("Main..." + i);
        }
    }
}
