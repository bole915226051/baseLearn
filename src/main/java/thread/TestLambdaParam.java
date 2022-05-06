package thread;

/**
 * labmbda表达,测试带有入参
 */
public class TestLambdaParam implements Sout {
    // 匿名内部类
    static class Sout1 implements Sout {

        @Override
        public void sout(String a, String b) {
            System.out.println("a = " + a + ",b = " + b);
        }
    }

    @Override
    public void sout(String a, String b) {
        System.out.println("a = " + a + ",b = " + b);
    }

    public static void main(String[] args) {
        Sout sout = new TestLambdaParam();
        sout.sout("A", "A");


        sout = new Sout1();
        sout.sout("B", "B");

        //  局部内部类
        class Sout2 implements Sout {

            @Override
            public void sout(String a, String b) {
                System.out.println("a = " + a + ",b = " + b);
            }
        }
        sout = new Sout2();
        sout.sout("C", "C");

        //  匿名内部类
        sout = new Sout() {
            @Override
            public void sout(String a, String b) {
                System.out.println("a = " + a + ",b = " + b);
            }
        };
        sout.sout("D", "D");

        //  Lambda表达式
        sout = (a, b) -> {
            System.out.println("a = " + a + ",b = " + b);
        };
        sout.sout("E", "E");
    }
}


interface Sout {
    void sout(String a, String b);
}