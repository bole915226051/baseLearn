package thread;

/**
 * 1.继承Runnable接口
 * 2.实现run方法
 * 3.new Thread将对象当参数传进去（）
 * 4.调用start方法;
 */
public class TestRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Runnable..." + i);
        }
    }

    public static void main(String[] args) {
        //  创建Runnable接口的实现类
        TestRunnable testRunnable = new TestRunnable();
        //  创建一个线程对象 （代理）
        new Thread(testRunnable).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("Main..." + i);
        }
    }
}
