package main.java.Test;

/**
 * @desc:
 * @Date: 2019/1/20 9:47
 */
public class GetUglyNumber {

    public static void main(String[] args) {

        System.out.println(GetUglyNumber_Solution(0));
    }

    public static int GetUglyNumber_Solution(int index) {

        if (index == 0) return 0;

        int a[] = new int[index];
        int t2 = 0, t3 = 0, t5 = 0;
        a[0] = 1;
        for (int i = 1; i < index; i++) {
            a[i] = Cmin(a[t2] * 2, a[t3] * 3, a[t5] * 5);

            if (a[t2] * 2 == a[i]) t2++;
            if (a[t3] * 3 == a[i]) t3++;
            if (a[t5] * 5 == a[i]) t5++;
        }
        return a[index - 1];
    }

    static int Cmin(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
}
