package main.java.Test;

import java.util.Arrays;

/**
 * @Desc:
 * @Date: 2019/1/21 21:35  better late than never. 认真思考，不要直接就动手写
 */
public class Sum {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(6));
    }

    public static int Sum_Solution(int n) {

        int sum = n;
        boolean bool = (n != 0) && ((sum += Sum_Solution(n - 1)) != 0);
        return sum;
    }

}
