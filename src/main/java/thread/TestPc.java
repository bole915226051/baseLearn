package thread;

/**
 * 练习:生产者消费者模型->管程法
 */
public class TestPc {
    public static void main(String[] args) {
        Syn syn = new Syn();
        Producer producer = new Producer(syn);
        Consumer consumer = new Consumer(syn);
        new Thread(producer, "生产者").start();
        new Thread(consumer, "消费者").start();
    }

}

//  产品
class Product {
    int id;

    Product(int id) {
        this.id = id;
    }
}


//  生产者
class Producer implements Runnable {
    Syn syn;

    Producer(Syn syn) {
        this.syn = syn;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                this.syn.add(new Product(i + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


//  消费者
class Consumer implements Runnable {
    Syn syn;

    Consumer(Syn syn) {
        this.syn = syn;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                this.syn.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//  缓冲区
class Syn {
    //  缓冲池
    Product[] products = new Product[20];
    //  计数器
    int count = 0;

    //  投入产品
    public synchronized void add(Product product) throws InterruptedException {
        //  缓冲池已经满了
        if (count == products.length) {
            this.wait();
        }
        this.products[count] = product;
        count++;
        System.out.println("用户:" + Thread.currentThread().getName() + ",生产了第" + product.id + "。");
        //  通知消费者可以消费了
        this.notifyAll();
    }

    //  获取产品
    public synchronized void get() throws InterruptedException {
        //  缓冲池已经没有产品了。等待生产者
        if (count == 0) {
            this.wait();
        }
        count--;
        Product product = products[count];
        System.out.println("用户:" + Thread.currentThread().getName() + ",消费了第" + product.id + "。");
        //通知消费者
        this.notifyAll();
    }
}