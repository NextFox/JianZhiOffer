package main.java.Test;

/**
 * @desc:
 * @Date: 2019/1/19 15:33
 */
public class NumberOf1Between1AndN {

    public static void main(String[] args) {

        System.out.println(NumberOf1Between1AndN_Solution(13));
    }

    public static int NumberOf1Between1AndN_Solution(int n) {

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (i != 0) {
                if (i % 10 == 1)
                    count++;
                i /= 10;
            }
            i = j;
        }
        return count;
    }
}
