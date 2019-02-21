package main.java.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Desc:
 * @Date: 2019/1/21 12:15  better late than never. 认真思考，不要直接就动手写
 */
public class FindNumsAppearOnce_ {

    public static void main(String[] args) {
        int array[] = {4,6,2,2,3,3,8,8,9,9,1000000,1000000};
        int num1[] = new int[0];
        int num2[] = new int[0];
        FindNumsAppearOnce(array,num1,num2);
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        Arrays.sort(array);
        int len = array.length;
        int size = Math.max(array.length, array[array.length - 1])+1;

        int count[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        for (int i = 0; i < array.length; i++) {
            if (count[array[i]] == 1)
                arrayList.add(array[i]);
        }
        if (arrayList.size() != 0) {
            num1[0] = arrayList.get(0);
            System.out.println(num1);
            num2[0] = arrayList.get(1);
            System.out.println(num2);
        }

    }
}
