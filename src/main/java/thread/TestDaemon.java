package thread;

/**
 * 练习守护线程。
 * 1.人生不过3W天。
 * 2.创建一个守护线程
 */
public class TestDaemon {
    public static void main(String[] args) {
        My my = new My();
        Daemon daemon = new Daemon();

        Thread thread = new Thread(daemon);
        //  线程默认为false, 创建的线程,默认是守护线程
        thread.setDaemon(true);
        thread.start();
        new Thread(my).start();
    }
}


class My implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("My...");
        }
    }
}

class Daemon implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("daemon");
        }
    }
}