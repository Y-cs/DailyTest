package e0101;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/26 17:48
 * @Description:
 **/
public class IsUnique {

    public boolean isUnique(String astr) {
        char[] chars = astr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (int j = i + 1; j < chars.length; j++) {
                if (temp == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }


}
