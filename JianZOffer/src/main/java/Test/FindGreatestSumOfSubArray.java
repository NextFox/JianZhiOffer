package main.java.Test;

/**
 * @desc:
 * @Author: WangJ
 * @Date: 2019/1/19 15:44
 */
public class FindGreatestSumOfSubArray {

    public static void main(String[] args) {

    }

    public int FindGreatestSumOfSubArray(int[] array) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }
}
