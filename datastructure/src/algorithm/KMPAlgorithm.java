package algorithm;

import java.util.Arrays;

/**
 * KMP算法进行字符匹配
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1  = "BBC ABCDAB ABCDABCDABDE ";
        String str2 = "ABCDABD";

        int[] next = kmpNext("ABCDABD");
        System.out.println(Arrays.toString(next));

        int kmpSearch = kmpSearch(str1, str2, next);
        System.out.println(kmpSearch);
    }

    /**
     * 获取字符串的部分匹配值
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest){
        //保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;//字符串长度为1，部分匹配值为0
        for (int i = 1,j = 0; i < dest.length(); i++) {

            //dest.charAt(i) != dest.charAt(j)时，需要从next[j - 1]获取新j
            //直到dest.charAt(i) == dest.charAt(j)时退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }

            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * kmp探索算法
     * @param str1 源字符串
     * @param str2 子字符串
     * @param next 部分匹配表
     * @return
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        for (int i = 0,j = 0; i < str1.length(); i++) {

            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j - 1];
            }
            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()){
                return i - j + 1;
            }
        }
        return -1;
    }
}
