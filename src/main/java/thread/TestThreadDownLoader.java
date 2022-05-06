package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

/**
 * 测试多线程下载文件
 */
public class TestThreadDownLoader extends Thread {
    String url;
    String name;

    TestThreadDownLoader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoad webDownLoad = new WebDownLoad();
        webDownLoad.webDownLoad(this.url, this.name);

    }

    public static void main(String[] args) {
        TestThreadDownLoader testThreadDownLoader1 = new TestThreadDownLoader("https://pics5.baidu.com/feed/5ab5c9ea15ce36d3abfdbbb3418d698ee850b13b.jpeg?token=ed9364ce47f0603962a462a7e14a0f9d", "1.jpeg");
        testThreadDownLoader1.start();

        TestThreadDownLoader testThreadDownLoader2 = new TestThreadDownLoader("https://pics6.baidu.com/feed/63d9f2d3572c11df24414767185931d9f603c26e.jpeg?token=39fa1942bafdd9e0c0ea87346416f1fa", "2.jpeg");
        testThreadDownLoader2.start();

        TestThreadDownLoader testThreadDownLoader3 = new TestThreadDownLoader("https://pics1.baidu.com/feed/e7cd7b899e510fb32f58b06b584d9b9cd0430c14.jpeg?token=d6e43fa488678fbb28eff2fb701706ec", "3.jpeg");
        testThreadDownLoader3.start();
    }
}

