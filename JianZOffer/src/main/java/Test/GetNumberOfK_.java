package main.java.Test;

import java.util.Arrays;

/**
 * @Desc:
 * @Date: 2019/1/20 17:39  better late than never.
 */
public class GetNumberOfK_ {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 3, 3, 3, 4, 5};

        System.out.println(GetNumberOfK(array, 3));
    }

    public static int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        //定义一个数组count[array[lenth-1]]
        int len = array.length;
        int size = array[len - 1];
        Arrays.sort(array);
        int ta = Math.max(len, size) + 10;
        int count[] = new int[ta];
        //出现一次加一次
        for (int i = 0; i < array.length; i++) {
            ++count[array[i]];
        }
        int i;
        for (i = 0; i < array.length; i++) {
            if (k != array[i])
                continue;
            else break;
        }
        if (i == array.length) return 0;
        else return count[k];
    }

}
