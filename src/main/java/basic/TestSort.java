package basic;

import java.util.Arrays;

/**
 * 练习冒泡排序
 *
 * 外圈循环11遍。
 * 1内圈循环到10停止,[10]和[1]比较。
 * 2内圈循环到9停止,[9]和[10]比较。最后一位一定是最大(最小)的数。
 */
public class TestSort {
    public static void main(String[] args) {
        int[] array = {1, 8, 2, 6, 6, 4, 2, 5, 0, 8, 0};
        sort(array);

    }

    static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int y = 0; y < array.length - i - 1; y++) {
                if (array[y] < array[y + 1]) {
                    int tmp = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

}
