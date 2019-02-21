package main.java.Test;

/**
 * @Desc:
 * @Date: 2019/1/22 21:53  better late than never. 认真思考，不要直接就动手写
 */
public class isNumeric_ {

    public static void main(String[] args) {
        String str = ".1416";
        System.out.println(isNumeric(str.toCharArray()));
    }

    public static boolean isNumeric(char[] str) {

        // 如果这个数使用科学计数法表示，将数字分成两部分判断
        int posE = -1;
        if (contains(str, 'E') || contains(str, 'e')) {
            for (int i = 0; i < str.length; i++) {
                if (str[i] == 'E' || str[i] == 'e') {
                    posE = i;
                    break;
                }
            }
            //如果 'E' || 'e'在开始与结尾的位置，说明错误
            if (posE == 0 || posE == str.length - 1) return false;
            char left[] = new char[posE];
            char right[] = new char[str.length - posE - 1];
            left = subString(str, 0, posE);
            right = subString(str, posE + 1, str.length);
            // left判断与非科学计数法一样

            // right判断必须为整数
            if (startWith(right, '+') || startWith(right, '-')) {
                right = subString(right, 1, right.length);
            }
            return isDecimal(left) && isDigit(right);
        } else return isDecimal(str);
    }

    static boolean isDigit(char[] num) {
        if (contains(num, '-') || contains(num, '+')) {
            num = subString(num, 1, num.length);
            for (int i = 0; i < num.length; i++) {
                if (num[i] > '9' || num[i] < '0') return false;
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] > '9' || num[i] < '0') return false;
        }
        return true;
    }

    static boolean contains(char[] str, char ch) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ch) return true;
        }
        return false;
    }

    static boolean startWith(char[] str, char ch) {
        if (str[0] == ch) return true;
        return false;
    }

    static boolean isDecimal(char[] str) {
        if (startWith(str, '-') || startWith(str, '+')) {
            str = subString(str, 1, str.length);
        }
        if (contains(str, '.')) {
            int posE = -1;
            for (int i = 0; i < str.length; i++) {
                if (str[i] == '.') {
                    posE = i;
                    break;
                }
            }
            if (posE == 0 || posE == str.length - 1) return true;
            char[] left = new char[posE];
            char[] right = new char[str.length - posE - 1];
            left = subString(str, 0, posE);
            right = subString(str, posE + 1, str.length);
            return isDigit(left) && isDigit(right);
        } else return isDigit(str);
    }

    static char[] subString(char[] str, int start, int end) {
        char sta[] = new char[end - start];
        for (int i = start; i < end; i++) {
            sta[i - start] = str[i];
        }
        return sta;
    }

}
