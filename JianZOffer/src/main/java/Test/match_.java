package main.java.Test;

/**
 * @Desc: 分析：
 * 递归实现
 * 每次分别在str 和pattern中取一个字符进行匹配，如果匹配，则匹配下一个字符，否则，返回不匹配。
 * 设匹配递归函数 match(str, pattern)。
 * 如果模式匹配字符的下一个字符是‘*’:
 * •如果pttern当前字符和str的当前字符匹配，：有以下三种可能情况
 * （1）pttern当前字符能匹配 str 中的 0 个字符：match(str, pattern+2)
 * （2）pttern当前字符能匹配 str 中的 1 个字符：match(str+1, pattern+2)
 * （3）pttern当前字符能匹配 str 中的 多 个字符：match(str+1, pattern)
 *  如果pttern当前字符和和str的当前字符不匹配
 * pttern当前字符能匹配 str 中的 0 个字符：(str, pattern+2)
 * 如果模式匹配字符的下一个字符不是‘*’，进行逐字符匹配。
 * 对于 ‘.’ 的情况比较简单，’.’ 和一个字符匹配 match(str+1, pattern+1)
 * 另外需要注意的是：空字符串”” 和 “.*” 是匹配的
 * 原文：https://blog.csdn.net/hll174/article/details/51001253
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 * @Date: 2019/1/22 19:30  better late than never. 认真思考，不要直接就动手写
 */
public class match_ {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        return matchCore(str, 0, pattern, 0);
    }

    public boolean matchCore(char[] str, int s, char[] pattern, int p) {
        if (str.length <= s && pattern.length <= p) return true;    //都匹配完了
        if (str.length > s && pattern.length <= p) return false;    //模式完了，字符串还有

        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            //当前pattern的下一个是*号
            //字符串完了
            if (s >= str.length) return matchCore(str, s, pattern, p + 2);
            else {
                if (pattern[p] == str[s] || pattern[p] == '.') {
                    //当前位置匹配完成，移动到下一个串
                    return matchCore(str, s, pattern, p + 2)
                            || matchCore(str, s + 1, pattern, p + 2)
                            || matchCore(str, s + 1, pattern, p);
                } else return matchCore(str, s, pattern, p + 2);
            }
        }
        //当前pattern不是*的时候
        if (s >= str.length) return false;
        else {
            if (str[s] == pattern[p] || pattern[p] == '.') return matchCore(str, s + 1, pattern, p + 1);
        }
        return false;
    }
}
