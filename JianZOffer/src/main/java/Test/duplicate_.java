package main.java.Test;

import java.util.Arrays;

/**
 * @Desc:
 * @Date: 2019/1/22 13:55  better late than never. 认真思考，不要直接就动手写
 */
public class duplicate_ {

    public static void main(String[] args) {
        int nubers[] = {};
        int dos[] ={};
        System.out.println(duplicate(nubers, 0,dos));
    }

    public static boolean duplicate(int numbers[], int length,int duplication[]) {

        if (numbers.length == 0) return false;
        if (numbers.length < 2) {
            duplication[0] = -1;
            return false;
        }
        int max = Math.max(numbers.length, numbers[numbers.length - 1]) + 1;
        int count[] = new int[max];
        for (int i = 0; i < numbers.length; i++) {
            count[numbers[i]]++;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (count[numbers[i]] > 1) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
