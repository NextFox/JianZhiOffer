package main.java.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Desc:
 * @Date: 2019/1/21 18:04  better late than never. 认真思考，不要直接就动手写
 */
public class FindNumbersWithSum_ {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        int count = 0, max = Integer.MAX_VALUE, ra = 0, rb = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                count = array[i] + array[j];
                if (count > sum) break;
                if (count == sum) {

                    int temp = array[i] * array[j];
                    if (temp < max) {
                        max = temp;
                        ra = array[i];
                        rb = array[j];
                    }
                }
            }
            count = 0;
        }
        if (ra == 0)return list;
        list.add(ra);
        list.add(rb);
        return list;
    }
}
