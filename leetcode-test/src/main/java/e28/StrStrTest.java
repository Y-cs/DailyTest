package e28;


import org.junit.jupiter.api.Test;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/7 14:55
 * @Description:
 **/
public class StrStrTest {

    StrStr strStr = new StrStr();

    @Test
    public void test1() {
        int i = strStr.strStr("hello", "ll");
        System.out.println(i);
        assert i==2;
    }
    @Test
    public void test2() {
        int i = strStr.strStr("hello", "a");
        System.out.println(i);
        assert i==-1;
    }
    @Test
    public void test3() {
        int i = strStr.strStr("hello", "");
        System.out.println(i);
        assert i==0;
    }
    @Test
    public void test4() {
        int i = strStr.strStr("a", "a");
        System.out.println(i);
        assert i==0;
    }
    @Test
    public void test5() {
        int i = strStr.strStr("mississippi", "issip");
        System.out.println(i);
        assert i==4;
    }

}