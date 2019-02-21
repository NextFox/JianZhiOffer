package main.java.Test;

/**
 * @Desc:
 * @Date: 2019/1/22 13:15  better late than never. 认真思考，不要直接就动手写
 */
public class Add_ {

    public int Add(int num1, int num2) {

        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
