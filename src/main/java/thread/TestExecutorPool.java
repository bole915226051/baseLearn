package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过线程池,创建多线程
 */
public class TestExecutorPool {

    public static void main(String[] args) {
        //  创建一个线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        Pool pool = new Pool();
        service.execute(pool);
        service.execute(pool);
        service.execute(pool);
        service.execute(pool);
        service.execute(pool);
        service.shutdown();
    }
}


class Pool extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}