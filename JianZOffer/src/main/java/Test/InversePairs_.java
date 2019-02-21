package main.java.Test;

import java.util.ArrayList;

/**
 * @desc:
 * @Date: 2019/1/20 12:27
 */
public class InversePairs_ {


    public static void main(String[] args) {
        int array[] = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650,
                418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233,
                144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936,
                275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259,
                655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80,
                45, 848, 38, 811, 267, 575};
        System.out.println(InversePairs(array));
    }

    public static int InversePairs(int[] array) {
        int len = array.length;
        if (array == null || array.length == 0) return 0;
        return mergeSort(array, 0, len - 1);
    }

    static int mergeSort(int[] array, int start, int end) {
        if (end == start) return 0;
        int mid = (start + end) / 2;
        int leftCount = mergeSort(array, start, mid);
        int rightCount = mergeSort(array, mid + 1, end);

        int i = mid, j = end;
        int copy[] = new int[end - start + 1];
        int copy_index = end - start;
        int count = 0;

        while (i >= start && j >= mid + 1) {
            if (array[i] > array[j]) {
                copy[copy_index--] = array[i--];
                count += j - mid;
                if (count > 1000000007)
                    count %= 1000000007;
            } else {
                copy[copy_index--] = array[j--];
            }
        }

        while (i >= start) {
            copy[copy_index--] = array[i--];
        }
        while (j >= mid + 1) {
            copy[copy_index--] = array[j--];
        }
        i = 0;
        while (start <= end) {
            array[start++] = copy[i++];
        }

        return (leftCount + rightCount + count) % 1000000007;
    }

/*
    //方法1 gg
    public static int InversePairs(int[] array) {
        int count = 0;
        ArrayList arrayList = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++)
                if (max(array[i], array[j]) != 0)
                    count++;
        }
        return count%1000000007;
    }

    static int max(int a, int b) {
        if (a > b) return a;
        return 0;
    }*/
}
