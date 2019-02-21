package main.java.Test;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @desc:
 * @Date: 2019/1/20 10:29
 */
public class FirstNotRepeatingChar_ {


    public static void main(String[] args) {
        String str = "bbbssaaajjigh";
        System.out.println(FirstNotRepeatingChar(str));
    }

    public static int FirstNotRepeatingChar(String str) {

        char chStr[] = str.toCharArray();
        Arrays.sort(chStr);
        int ch[] = new int[26], value = 1;
        HashMap hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < chStr.length - 1; i++) {
            if (chStr[i] == chStr[i + 1]) {
                value++;
                hashMap.put(chStr[i], value);
            } else {
                value = 1;
            }
        }

        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry) iterator.next();
            Character key = entry.getKey();
            if (entry.getValue() >= 1) {
                str = str.replace(Character.toString(key), "*");
            }
        }
        int i;
        for( i=0;i<str.length();i++){
            if(str.charAt(i)!='*')return i;
        }
        return -1;
    }
}
