package m5;


import org.junit.jupiter.api.Test;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/8 10:22
 * @Description:
 **/
public class LongestPalindromeTest {

    private LongestPalindrome longestPalindrome = new LongestPalindrome();

    private String test = "";

    @Test
    public void test1() {
        after();
    }

    @Test
    public void test2() {
        test = "aaaaaa";
        after();
    }

    @Test
    public void test3() {
        test = "abcba";
        after();
    }

    @Test
    public void test4() {
        test = "cagqergabcbafasdfas";
        after();
    }


    public void after() {
        String s = longestPalindrome.longestPalindrome(test);
        System.out.println(test + "----->" + s);
    }

}