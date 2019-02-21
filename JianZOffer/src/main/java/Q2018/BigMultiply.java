package main.java.Q2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Desc:
 * @Date: 2019/2/12 13:39  better late than never. 认真思考，不要直接就动手写
 */
public class BigMultiply {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input[] = scanner.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            int temp = Integer.parseInt(input[i]);
            if (temp < 0) temp = -temp;
            arrayList.add(temp);
        }

        System.out.println(BigMult(arrayList, n));
    }

    public static long BigMult(ArrayList<Integer> array, int n) {
        Collections.sort(array);
        if (n < 3) return 0;
        int len = array.size();
        return (long)array.get(len - 1) * array.get(len - 2) * array.get(len - 3);
    }
}
