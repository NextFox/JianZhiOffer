package main.java.Test;

/**
 * @Desc:
 * @Date: 2019/1/21 18:27  better late than never. 认真思考，不要直接就动手写
 */
public class LeftRotateString_ {

    public String LeftRotateString(String str,int n) {

        if(str==null||str.length()==0)return "";
        String stra = str.substring(0,n);
        String strb = str.substring(n,str.length());
        return strb+stra;
    }
}
