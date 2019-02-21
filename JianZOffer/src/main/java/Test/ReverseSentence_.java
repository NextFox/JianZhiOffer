package main.java.Test;

import java.util.Stack;

/**
 * @Desc:
 * @Date: 2019/1/21 18:31  better late than never. 认真思考，不要直接就动手写
 */
public class ReverseSentence_ {

    public static void main(String[] args) {
        System.out.println(ReverseSentence(" "));
    }

    public static String ReverseSentence(String str) {

        //这里错了很久，问题你都不知道有多少空格
        if (str == null || str.trim().equals("")) return str;
        char chStr[] = revers(str.toCharArray());
        StringBuffer stringBuffer = new StringBuffer();
        String strb = new String(chStr);
        String strc[] = strb.split(" ");
        for (int i = 0; i < strc.length; i++) {
            char temp[] = revers(strc[i].toCharArray());
            stringBuffer.append(new String(temp));
            if (i != strc.length - 1)
                stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    static char[] revers(char strd[]) {
        int j = 0, len = strd.length;
        if (len == 0 && strd[0] == ' ') return " ".toCharArray();
        char stra[] = new char[len];
        for (int i = strd.length - 1; i >= 0; ) {
            stra[j++] = strd[i--];
        }
        return stra;
    }
}
