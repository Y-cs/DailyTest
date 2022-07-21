package m8;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/17 9:49
 * @Description:
 **/
public class M8 {

    static int maxPositive = 0x7fffffff / 10;
    static int maxNegative = 0x80000000 / 10;

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        boolean symbol = true;
        boolean haveSymbol=false;
        for (char c : chars) {
            if (c == ' '&& !haveSymbol) {
            } else if (c == '+' && !haveSymbol) {
                symbol = true;
                haveSymbol=true;
            } else if (c == '-'&& !haveSymbol) {
                symbol = false;
                haveSymbol=true;
            } else if (c >= '0' && c <= '9') {
                haveSymbol=true;
                int num = c - '0';
                if (symbol) {
                    if (ans > maxPositive || (ans *= 10) >= (0x7fffffff - num)) {
                        return 0x7fffffff;
                    }
                    ans += num;
                } else {
                    if (ans < maxNegative || (ans *= 10) <= (0x80000000 + num)) {
                        return 0x80000000;
                    }
                    ans -= num;
                }
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        M8 m8 = new M8();
        System.out.println(m8.myAtoi("00000-42a1234"));
        //System.out.println(0x80000000);

    }


}
