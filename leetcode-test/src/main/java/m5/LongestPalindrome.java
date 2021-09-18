package m5;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/7 18:09
 * @Description:
 **/
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int k = 0;
            while ((i - k > 0 && i + k < chars.length)) {
                k++;
            }
        }
        return s;
    }

}
