package thread;

public class Test {
    public static void main(String[] args) {
        new Test1().run();
    }


}


class Test1 {
    void run() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
