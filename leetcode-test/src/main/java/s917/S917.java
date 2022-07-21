package s917;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/3 16:49
 * @Description:
 **/
public class S917 {
    //    a-bC-dEf-ghIj
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int low = 0, high = chars.length - 1;
        boolean zx = true;
        while (low < high) {
            if (zx) {
                if (isLetter(chars[low])) {
                    zx = false;
                } else {
                    low++;
                }
            }else{
                if (isLetter(chars[high])) {
                    zx = true;
                    chars[low]^=chars[high];
                    chars[high]^=chars[low];
                    chars[low]^=chars[high];
                    low++;
                }
                high--;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        S917 s917 = new S917();
        System.out.println(s917.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(s917.reverseOnlyLetters("ab-cd"));
    }

}
