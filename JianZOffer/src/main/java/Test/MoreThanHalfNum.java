package main.java.Test;

import java.util.Arrays;

/**
 * @desc:
 * @Date: 2019/1/19 15:08
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {

        int[] array = {1,2,3,2,2,2,5,4,2};
        //int[] array = {1};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    public static int MoreThanHalfNum_Solution(int[] array) {

        Arrays.sort(array);
        if (array.length == 1) return array[0];
        int[] count = new int[array.length - 1];
        for (int i = 0; i < array[array.length - 1]; i++) {
            count[i]++;
            if (array[i] == array[i + 1])
                ++count[array[i]];

        }
        int j;
        for (j = 0; j < array[array.length - 1]; j++) {
            if (count[j] > array.length / 2)
                return j;
        }
        return 0;
    }
}
