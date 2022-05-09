package thread;

/**
 * 测试,获取线程状态
 */
public class TestState implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestState state = new TestState();
        Thread thread = new Thread(state);

        System.out.println("start 前 Thread 状态：" + thread.getState());
        thread.start();
        System.out.println("start 后 Thread 状态：" + thread.getState());

        while (thread.getState() != Thread.State.TERMINATED) {
            Thread.sleep(200);
            System.out.println("实时监测 Thread 状态：" + thread.getState());

        }
    }
}
