package main.java.Test;

import java.util.ArrayList;

/**
 * @Desc:
 * @Date: 2019/2/7 12:34  better late than never. 认真思考，不要直接就动手写
 */
public class maxInWindows_ {


    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> array = new ArrayList<>();
        if (size == 0) return array;
        for (int i = 0; i <= num.length - size; i++) {
            for (int j = i; j < i + size; j++) {
                while (num[j] > max) {
                    max = num[j];
                }

            }
            array.add(max);
            max = Integer.MIN_VALUE;
        }
        return array;
    }

    public static void main(String[] args) {
        int num[] = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(maxInWindows(num, 3));
    }
}
