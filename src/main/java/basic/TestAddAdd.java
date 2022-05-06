package basic;

/**
 * 练习++
 */
public class TestAddAdd {
    public static void main(String[] args) {
        int i = 1;
        int y = i++;
        //  i++ = 先赋值,再运算
        System.out.println("i=" + i);
        System.out.println("y=" + y);

        int c = 1;
        int f = ++c;
        //  ++c = 先运算,再赋值
        System.out.println("c=" + c);
        System.out.println("f=" + f);

        int a = 1;
        int b = a + 1;
        System.out.println("a=" + a);
        System.out.println("b=" + b);


    }
}
