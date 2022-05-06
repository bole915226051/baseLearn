package thread;

import sun.tools.jconsole.Tab;

/**
 * 练习：生产者消费者->信号灯法,标志位解决
 * 利用标志位
 */
public class TestPc2 {
    public static void main(String[] args) {
        Table table = new Table();

        Producer1 producer1 = new Producer1(table);
        Consumer1 consumer1 = new Consumer1(table);
        new Thread(producer1).start();
        new Thread(consumer1).start();
    }

}

/**
 * 桌子
 */
class Table {
    String name;
    boolean flag = false;

    public synchronized void product(String name) {
        //  如果有 食物,则稍等
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //  生产了 食物
        this.name = name;
        try {
            Thread.sleep(100);
            System.out.println("生产了" + this.name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        //  通知观众看
        this.notifyAll();
    }

    public synchronized void consumer() {
        //  没有食物,等待
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费了" + this.name);
        this.flag = false;
        this.notifyAll();
    }
}

/**
 * 生产者
 */
class Producer1 extends Thread {
    Table table;

    public Producer1(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        String[] strings = {"鸡", "鸭", "鱼"};
        for (int i = 0; i < 50; i++) {
            this.table.product(strings[i % 3]);
        }
    }
}

/**
 * 消费者
 */
class Consumer1 extends Thread {
    Table table;

    public Consumer1(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            table.consumer();
        }
    }
}