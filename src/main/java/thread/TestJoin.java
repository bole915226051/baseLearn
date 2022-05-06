package thread;

/**
 * 测试线程Join方法模拟插队。
 * 1.主线程正常执行,根据某个业务逻辑,礼让子线程,等子线程跑完之后,主线程再继续执行
 */

public class TestJoin implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("插队执行--->" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        thread.getState();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                thread.join();
            }
            System.out.println("Main正常执行--->" + i);
        }
    }
}


