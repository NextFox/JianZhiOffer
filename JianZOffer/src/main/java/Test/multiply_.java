package main.java.Test;

/**
 * @Desc:
 * @Date: 2019/1/22 19:11  better late than never. 认真思考，不要直接就动手写
 */
public class multiply_ {
    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5};
        int C[] = multiply(A);
        for (int i = 0; i < C.length; i++) System.out.println(C[i]);
    }

    public static int[] multiply(int[] A) {

        int re[] = {0};
        if (A.length == 0 || A == null) return re;
        int len = A.length;
        int B[] = new int[len];
        int cnta = 1, cntb = 1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (j < i) cnta *= A[j];
                else cntb *= A[j + 1];
            }
            B[i] = cnta * cntb;
            cnta = 1;
            cntb = 1;
        }
        return B;
    }
}
