package main.java.Q2018;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Desc:
 * @Date: 2019/2/20 18:25  better late than never. 认真思考，不要直接就动手写
 */
public class BigIntegerMultply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input[] = scanner.nextLine().split(" ");
        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);
        BigInteger c = a.multiply(b);
        System.out.println(c);
    }
}
