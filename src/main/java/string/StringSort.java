package string;

public class StringSort {

    public static void main(String[] age) {
        System.out.println(stringSort1("dddcccbbaA"));
    }


    static String stringSort1(String string) {
        String sbLower = new String();
        String sbUpper = new String();
        char[] chars = string.toCharArray();
        for (char charTmp : chars) {
            //  去重,区分大小写
            if (charTmp >= 'a' && charTmp <= 'z' && !sbLower.contains(String.valueOf(charTmp))) {
                sbLower += charTmp;
            }
            //  去重,区分大小写
            if (charTmp >= 'A' && charTmp <= 'Z' && !sbUpper.contains(String.valueOf(charTmp))) {
                sbUpper += charTmp;
            }
        }
        String outPrintln = new String();
        for (String tmp : sbLower.split("")) {
            outPrintln += tmp + "(" + (string.length() - string.replace(tmp, "").length()) + ")";
        }
        for (String tmp : sbUpper.split("")) {
            outPrintln += tmp + "(" + (string.length() - string.replace(tmp, "").length()) + ")";
        }
        return outPrintln;

    }
}
