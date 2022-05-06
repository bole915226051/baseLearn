package thread;

/**
 * 练习线程优先级
 */
public class TestPriority {
    public static void main(String[] args) {
        MyPriority priority = new MyPriority();
        Thread thread = new Thread(priority, "thread");
        Thread thread1 = new Thread(priority, "thread1");
        Thread thread2 = new Thread(priority, "thread2");
        Thread thread3 = new Thread(priority, "thread3");
        Thread thread4 = new Thread(priority, "thread4");
        Thread thread5 = new Thread(priority, "thread5");
        Thread thread6 = new Thread(priority, "thread6");

        //2.查看主线程的优先级
        System.out.println("当前线程名称:" + Thread.currentThread().getName() + ",当前线程优先级:" + Thread.currentThread().getPriority());

        thread.setPriority(10);
        thread1.setPriority(1);
        thread2.setPriority(2);
        thread3.setPriority(3);
        thread4.setPriority(4);
        thread5.setPriority(5);
        thread6.setPriority(6);

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}


//1.先创建一个线程类
class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println("当前线程名称:" + Thread.currentThread().getName() + ",当前线程优先级:" + Thread.currentThread().getPriority());
    }
}