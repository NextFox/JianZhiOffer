package main.java.BaseAG;

/**
 * @Desc:
 * @Date: 2019/2/10 14:43  better late than never. 认真思考，不要直接就动手写
 */
public class KMP {

    //KMP匹配 时间复杂度O(m+n) m为s的长度，n为p的长度

    //1、朴素字符串匹配   时间复杂度O(m*n) m为s的长度，n为p的长度
    public static int commonKMP(char s[], char p[]) {
        int slen = s.length;
        int plen = p.length;
        int i = 0, j = 0;
        while (i < slen && j < plen) {
            if (s[i] == p[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        //匹配成功
        if (j == plen)
            return i - j;
        return -1;
    }

    //2、KMP
    public static int KMP_(char s[], char p[], int next[]) {
        getNext(p, next);
        int i = 0, j = 0;
        int slen = s.length;
        int plen = p.length;

        while (i < slen && j < plen) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else j = next[j];
        }
        if (j == plen) return i - j;
        return -1;
    }

    //next数组求值  p为模式串   未优化版本
    static void getNext(char p[], int next[]) {
        int plen = p.length;
        int i = 0, j = -1;
        next[0] = -1;
        while (i < plen) {
            if (j == -1 || p[i] == p[j]) {
                i++;
                j++;
                next[i] = j;
            } else j = next[j];
        }
    }


    //next数组求值  p为模式串   未优化版本
    public static void getNextval(char p[], int next[]) {
        int plen = p.length;
        int i = 0, j = -1;
        next[0] = -1;
        while (i < plen) {
            if (j == -1 || p[i] == p[j]) {
                i++;
                j++;
                next[i] = j;
            } else j = next[j];
        }
    }

    public static void main(String[] args) {
        String s = "bbc abcdab abcdabcdabde";
        String p = "abcdabd";
        int next[] = new int[100];
        System.out.println(KMP_(s.toCharArray(), p.toCharArray(), next));
    }

}
