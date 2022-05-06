package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownLoad webDownLoad = new WebDownLoad();
        webDownLoad.webDownLoad(this.url, this.name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程实例
        TestCallable callable1 = new TestCallable("https://pics5.baidu.com/feed/5ab5c9ea15ce36d3abfdbbb3418d698ee850b13b.jpeg?token=ed9364ce47f0603962a462a7e14a0f9d", "1.jpeg");
        TestCallable callable2 = new TestCallable("https://pics6.baidu.com/feed/63d9f2d3572c11df24414767185931d9f603c26e.jpeg?token=39fa1942bafdd9e0c0ea87346416f1fa", "2.jpeg");
        TestCallable callable3 = new TestCallable("https://pics1.baidu.com/feed/e7cd7b899e510fb32f58b06b584d9b9cd0430c14.jpeg?token=d6e43fa488678fbb28eff2fb701706ec", "3.jpeg");
        // 创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //  将线程加入服务
        Future<Boolean> c1 = executorService.submit(callable1);
        Future<Boolean> c2 = executorService.submit(callable2);
        Future<Boolean> c3 = executorService.submit(callable3);
        //  获取执行结果
        System.out.println("c1=执行结果:" + c1.get());
        System.out.println("c2=执行结果:" + c2.get());
        System.out.println("c3=执行结果:" + c3.get());
        //  关闭服务
        executorService.shutdown();
    }

}


