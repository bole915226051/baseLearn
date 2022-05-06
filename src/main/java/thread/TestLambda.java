package thread;

/**
 * Lambda表达式
 */
public class TestLambda {

    /**
     * 静态内部类
     */
    static class SeeImpl1 implements See {
        @Override
        public void see() {
            System.out.println("see2");
        }
    }


    public static void main(String[] args) {
        See see = new SeeImpl();
        see.see();
        see = new SeeImpl1();
        see.see();
        /**
         * 局部内部类
         */
        class SeeImpl2 implements See {

            @Override
            public void see() {
                System.out.println("see3");
            }
        }
        see = new SeeImpl2();
        see.see();
        /**
         * 匿名内部类
         */
        see = new See() {
            @Override
            public void see() {
                System.out.println("see4");
            }
        };
        see.see();
        /**
         * lambda表达式
         */
        see = () -> System.out.println("see5");
        see.see();
    }
}

interface See {
    void see();
}

class SeeImpl implements See {

    @Override
    public void see() {
        System.out.println("see1");
    }
}


