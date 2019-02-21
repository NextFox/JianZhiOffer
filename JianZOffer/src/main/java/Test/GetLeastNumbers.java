package main.java.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @desc:
 * @Date: 2019/1/19 14:51
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> integers = GetLeastNumbers_Solution(input, 10);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (k > input.length) return integers;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            integers.add(input[i]);
        }
        return integers;
    }
}
