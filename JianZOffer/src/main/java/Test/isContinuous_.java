package main.java.Test;

import java.util.Arrays;

/**
 * @Desc:
 * @Date: 2019/1/21 19:59  better late than never. 认真思考，不要直接就动手写
 */
public class isContinuous_ {

    public boolean isContinuous(int[] numbers) {
        //首先把数组排序，再统计数组中0的个数，最后统计排序后的数组中相邻数字之间的空缺总数。
        // 如果空缺总数小于或者等于0的个数，那么这个数组就是连续的，否则不连续。
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int numberOfGap = 0;
        if (numbers.length == 0 || numbers == null) return false;
        //统计0的个数
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) ++numberOfZero;
        //统计数组中间隔数目
        int small = numberOfZero;
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[big] == numbers[small]) return false;

            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        if (numberOfGap > numberOfZero) return false;
        else return true;

    }
}
