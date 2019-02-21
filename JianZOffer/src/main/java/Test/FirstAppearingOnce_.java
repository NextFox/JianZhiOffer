package main.java.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Desc:
 * @Date: 2019/1/22 19:47  better late than never. 认真思考，不要直接就动手写
 */
public class FirstAppearingOnce_ {

    char cn[] = new char[256];
    StringBuffer stringBuffer = new StringBuffer();

    public void Insert(char ch) {
        ++cn[ch];
        stringBuffer.append(ch + "");
    }

    public char FirstAppearingOnce() {
        char t[] = stringBuffer.toString().toCharArray();
        for(int i=0;i<t.length;i++){
            if(cn[t[i]]==1)return t[i];
        }
        return '#';
    }
}
