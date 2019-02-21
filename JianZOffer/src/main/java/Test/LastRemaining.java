package main.java.Test;

import java.util.ArrayList;

/**
 * @Desc:
 * @Date: 2019/1/21 21:21  better late than never. 认真思考，不要直接就动手写
 */
public class LastRemaining {

    public int LastRemaining_Solution(int n, int m) {

        if (m == 0 || n == 0) return -1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) arrayList.add(i);

        int index = -1;
        while (arrayList.size() > 1) {
            index = (index + n) % m;
            arrayList.remove(index);
            index--;
        }
        return arrayList.get(0);

    }
}
