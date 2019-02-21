package main.java.Test;

/**
 * @desc:
 * @Date: 2019/1/20 8:09
 */
public class PrintMinNumber_ {

public static String PrintMinNumber(int[] numbers) {

        if (numbers == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        String pre, last;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {

                pre = numbers[i] + "" + numbers[j];
                last = numbers[j] + "" + numbers[i];
                if (compare(pre, last) > 0) {
                    exchange(numbers, i, j);
                }
            }
            stringBuilder.append(numbers[i]);
        }

        return stringBuilder.toString();
    }

    static void exchange(int[] nubers, int i, int j) {
        int temp = nubers[i];
        nubers[i] = nubers[j];
        nubers[j] = temp;
    }

    static int compare(String pre, String last) {
        int len1 = pre.length();
        int len2 = last.length();

        int min = Math.min(len1, len2);
        char cpre[] = pre.toCharArray();
        char clast[] = last.toCharArray();
        int k = 0;
        while (k < min) {
            char c1 = cpre[k];
            char c2 = clast[k];
            if (c1 != c2)
                return c1 - c2;
            k++;
        }
        return len1 - len2;
    }


}
