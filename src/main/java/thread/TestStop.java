package thread;

/**
 * 继承Thread类,重写Run方法
 * <p>
 * 测试stop停止线程
 */
public class TestStop implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run...Thread..." + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {

        TestThread testThread = new TestThread();
        new Thread(testThread).start();


        for (int i = 0; i < 1000; i++) {
            System.out.println("run...Main" + i);
            if (i == 900) {
                testThread.stop();
                System.out.println("停止 Thread线程");
            }
        }
    }
}
