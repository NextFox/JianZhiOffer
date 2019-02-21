package main.java.Test;


import java.util.*;

/**
 * @desc:
 * @Date: 2019/1/19 10:05
 */
public class Permutation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Permutation(input.nextLine());
    }

    public static ArrayList<String> Permutation(String str) {

        ArrayList<String> result = new ArrayList<>();
        TreeSet<String> temp = new TreeSet<>();
        if (str == null || str.equals("")) return result;

        Permutation(str.toCharArray(), 0, temp);
        result.addAll(temp);
        return result;
    }

    static void Permutation(char[] str, int i, TreeSet<String> result) {
        if (i == str.length) {
            result.add(String.valueOf(str));
            System.out.println();
        } else {
            for (int j = i; j < str.length; j++) {
                exchange(str, i, j);
                System.out.println(" exchange 上 : " + str[i] + "  " + str[j] + "  i = " + i + " j = " + j + "     str = " + String.valueOf(str));
                Permutation(str, i + 1, result);
                System.out.printf(" Permutation  i+1= %d i = %d j = %d\n", i + 1, i, j);
                exchange(str, i, j);
                System.out.println(" exchange 下 : " + str[i] + "  " + str[j] + "  i = " + i + " j = " + j + "     str = " + String.valueOf(str));
            }
        }
    }

    static void exchange(char[] str, int a, int b) {
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }

//TreeSet维护了一个插入顺序，HashSet没有按照插入顺序输出

/*

    static Set<String> hashSet = new HashSet<String>();


    static ArrayList<String> Permutation(String str) {

        ArrayList<String> result = new ArrayList<>();
        HashSet temp = new HashSet<String>();
        if (str == null || str.equals(""))
            return result;
        del(str.toCharArray(), 0, temp);
        return new ArrayList<>(temp);
    }

    static void del(char[] str, int i, HashSet<String> result) {

        if (i == str.length)
            result.add(String.valueOf(str));
        else {
            for (int j = i; j < str.length; j++) {
                exchange(str, i, j);
                del(str, i + 1, result);
                exchange(str, i, j);
            }
        }
    }

    static void exchange(char[] str, int a, int b) {
        char temp = str[a];
        str[a] = str[b];
        str[b] = temp;
    }
*/


}
