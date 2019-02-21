package main.java.Test;

import java.util.ArrayList;

/**
 * @Desc:
 * @Date: 2019/1/21 17:39  better late than never. 认真思考，不要直接就动手写
 */
public class FindContinuousSequence_ {

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(9));
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int len = sum / 2 + 1;
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                count += j;
                if (count > sum) break;
                if (count == sum) {
                    for (int k = i; k <= j; k++) {
                        list.add(k);
                    }
                    pathList.add(list);
                    if (list != null)
                        list = new ArrayList<>();
                    continue;
                }
            }
            count = 0;
        }
        return pathList;
    }
}
