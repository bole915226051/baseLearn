package string;

import ab.AbstractTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringTest {
    public static void main(String[] args) {
        //字符串比较
        //stringCompare();
        //字符串是否回文判断
//        System.out.println(stringPalindrome1("abccba"));
//        System.out.println(stringPalindrome1("abcacba"));
//        System.out.println(stringPalindrome1("abcacbaa"));

//        System.out.println(stringPalindrome2("abccba"));
//        System.out.println(stringPalindrome2("abcacba"));
//        System.out.println(stringPalindrome2("abcacbaa"));
        //Java程序中规定了抽象类不能实例化
        //AbstractTest abstractTest = new AbstractTest();

        System.out.println(stringCount("dddcccbbaA"));


    }

    static String stringCount(String string) {
        String[] strings = string.split("");
        Arrays.sort(strings);
        Set<String> set = new HashSet<String>(Arrays.asList(strings));
        StringBuilder sb = new StringBuilder();

        for (String strSet : set) {
            String tmp = string.replace(strSet, "");
            sb.append(strSet).append("(").append(string.length() - tmp.length()).append(")");
        }
        return sb.toString();
    }


    static boolean stringPalindrome1(String str) {
        if (str.equals(new StringBuilder(str).reverse().toString())) {
            return true;
        }
        return false;
    }

    static boolean stringPalindrome2(String str) {
        if (str.equals(new StringBuilder(str).reverse().toString())) {
            return true;
        }
        return false;
    }

    static void stringCompare() {
        String s1 = "abc";
        String s2 = "a";
        String s3 = s2 + "bc";
        String s4 = "a" + "bc";
        String s5 = s3.intern();
        // false S3 = StringBuild.append() 会在heap堆中新建一个对象
        System.out.println(s1 == s3);
        // true  S4 = 编译中,会合并为abc,在字符串常量池中寻找,如果已经存在,则合并,占用一个空间
        System.out.println(s1 == s4);
        // true  s5 = intern方法,JDK 1.7之后,会先在字符串常量池中寻找,如果有,heap(堆)中的指向则是字符串常量池中的地址
        System.out.println(s1 == s5);
    }
}
