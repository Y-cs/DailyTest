package urlencoding;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/1 14:35
 * @Description:
 **/
public class Urlencoding {
    static BitSet dontNeedEncoding;

    private Urlencoding() {
    }

    static {
        dontNeedEncoding = new BitSet(128);
        int i;
        for (i = 'a'; i <= 'z'; i++) {
            dontNeedEncoding.set(i);
        }
        for (i = 'A'; i <= 'Z'; i++) {
            dontNeedEncoding.set(i);
        }
        for (i = '0'; i <= '9'; i++) {
            dontNeedEncoding.set(i);
        }
        dontNeedEncoding.set('+');
        dontNeedEncoding.set('-');
        dontNeedEncoding.set('_');
        dontNeedEncoding.set('.');
        dontNeedEncoding.set('*');
        dontNeedEncoding.set('%');
    }
    private static boolean isDigit16Char(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F');
    }
    /**
     * 字符串是否经过了url encode
     *
     * @param text 字符串
     * @return true表示是
     */
    public static boolean hasEnCode(String text) {
        if (StringUtils.isBlank(text)) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i);
            if (!dontNeedEncoding.get(c)) {
                return false;
            }
            if (c == '%' && (i + 2) < text.length()) {
                // 判断是否符合urlEncode规范
                char c1 = text.charAt(++i);
                char c2 = text.charAt(++i);
                if (!isDigit16Char(c1) || !isDigit16Char(c2)) {
                    return false;
                }
            }
        }
        return true;
    }
    @Test
    public void checkEncoding() {
        String str = "776C273C7FB5426CBDFB7B413FB4EAED";
        System.out.println(hasEnCode(str));
    }

}
