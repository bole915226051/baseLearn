package basic;


public class TestArray {
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10, 12, 14};
        System.out.println(getIndex(array, 15));
        System.out.println(getIndex(array, 4));


    }

    /**
     * 面试题：一个有序数组,将一个值插入数组中,保证数据还是有序
     */
    public static int getIndex_2(int array[], int key) {
        int min, max, mid;
        //  todo 未完成
        return 0;
    }

    /**
     * 练习:折半查找
     * 1.折半查找,需要针对有序数据。
     */
    public static int getIndex(int array[], int key) {
        int min, max, mid;
        //  初始最小坐标
        min = 0;
        //  初始最大坐标
        max = array.length;
        //  初始折半坐标
        mid = (min + max) / 2;
        //  如果最小坐标,大于最大坐标,则说明,已经查找不到数据了。
        while (min < max) {
            //  如果查询的值,大于折半值,则改变最小坐标值
            if (key > array[mid]) {
                min = mid + 1;
                //  如果查询的值,小于折半值,则改变最大坐标的值
            } else if (key < array[mid]) {
                max = mid - 1;
            } else {
                //  否则 就是肯定找到了
                return mid;
            }
            mid = (min + max) / 2;
        }
        return -1;
    }
}
