package e28;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/6 17:29
 * @Description:
 **/
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int i = 0;
        char key = needleChars[0];
        while (i <= haystackChars.length - needleChars.length) {
            if (haystackChars[i] == key) {
                int k = 0;
                while (k < needleChars.length) {
                    if (haystackChars[k + i] != needleChars[k]) {
                        break;
                    }
                    k++;
                }
                if (k == needleChars.length) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}
