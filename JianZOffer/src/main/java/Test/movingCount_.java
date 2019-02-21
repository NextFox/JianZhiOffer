package main.java.Test;

import java.util.Collections;

/**
 * @Desc:
 * @Date: 2019/2/7 15:38  better late than never. 认真思考，不要直接就动手写
 */
public class movingCount_ {

    public static int movingCount(int threshold, int rows, int cols) {
        boolean visited[] = new boolean[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited) ) {
            int flag = row * cols + col;
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row, col - 1, visited) +
                    movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || getDigit(row) + getDigit(col) > threshold || visited[row * cols + col])
            return false;
        return true;
    }

    static int getDigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(10, 1, 10));
    }
}
