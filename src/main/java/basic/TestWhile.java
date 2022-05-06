package basic;

/**
 * 练习   while   do..while
 */
public class TestWhile {
    public static void main(String[] args) {
        int i = 0;
        //  while语句,先判断,再执行
        while (i != 0) {
            System.out.println("while");
        }

        //  do..while语句,先执行一遍,在判断
        int a = 0;
        do {
            System.out.println("do..while");
        } while (a != 0);
    }
}
