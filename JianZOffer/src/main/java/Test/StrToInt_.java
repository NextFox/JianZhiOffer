package main.java.Test;

import java.util.ArrayList;

/**
 * @Desc:
 * @Date: 2019/1/22 13:23  better late than never. 认真思考，不要直接就动手写
 */
public class StrToInt_ {

    public int StrToInt(String str) {

        if (str.trim().length() == 0) return 0;
        int flag = 0;
        if (str.charAt(0) == '+') flag = 1;
        if (str.charAt(0) == '-') flag = 2;

        int start = flag > 0 ? 1 : 0;
        long res = 0;
        while (start < str.trim().length()) {
            if (str.charAt(start) > '9' || str.trim().charAt(start) < '0') return 0;
            res = res * 10 + (str.charAt(start) - '0');
            start++;

        }

        return flag == 2 ? -(int) res : (int) res;
    }
}
