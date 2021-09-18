package bitcalc;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/8/13 9:53
 * @Description:
 **/
public class BitCalc {

    /**
     * 1011
     */
    private final Integer a = 11;
    /**
     * 0100
     */
    private final Integer b = 8;

    @Test
    public void test1() {
        /**
         * '|'或操作符,位置上有一个1则结果为1
         *      11|8
         *      1011
         *      1000
         *  =   1011    =11
         */
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println("----");
        System.out.println(Integer.toBinaryString(a | b));
        System.out.print("=\t");
        System.out.println(a | b);
    }

    @Test
    public void test1Ext() {
        /**
         * |1会把最后一位强行摸成1    于是就获得了最近的奇数
         * 然后再减一就获得了最近的偶数
         */
        int i = 123;
        System.out.println((i | 1) - 1);
        int j = 125;
        System.out.println(j | 1);
    }

    @Test
    public void test2() {
        /**
         * '^'亦或操作符,位置上数据不同则为1相同为0
         *      11|8
         *      1011
         *      1000
         *  =   0011    =3
         *  亦或的逆运算是他本身
         */
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println("----");
        System.out.println(Integer.toBinaryString(a ^ b));
        System.out.print("=\t");
        System.out.println(a ^ b);
        System.out.println(520 ^ 120 ^ 120);
    }

    @Test
    public void test2Ext() {
        byte[] bytes = new byte["袁长帅".getBytes().length];
        int i = 0;
        for (byte bit : "袁长帅".getBytes()) {
            bytes[i++] = (byte) (bit ^ 115234);
        }
        System.out.println(new String(bytes));
        byte[] result = new byte["袁长帅".getBytes().length];
        i = 0;
        for (byte bit : bytes) {
            result[i++] = (byte) (bit ^ 115234);
        }
        System.out.println(new String(result));
    }

    @Test
    public void test3() {
        /**
         * '&'与操作符,位置上数据同为1则为1否则为0
         *      11|8
         *      1011
         *      1000
         *  =   0011    =3
         *  例如一个数 & 1的结果就是取二进制的最末位  ，二进制的最末位为0表示该数为偶数，最末位为1表示该数为奇数.
         */
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println("----");
        System.out.println(Integer.toBinaryString(a & b));
        System.out.print("=\t");
        System.out.println(a & b);
    }

    @Test
    public void test3Ext() {
        int i = 153, j = 154;
        System.out.println((i & 1) == 0);
        System.out.println((j & 1) == 0);
    }

    @Test
    public void test4() {
        /**
         * 移位运算符
         * 11>>1
         * 1000 0000 0000 1011
         */
        System.out.println(Integer.toBinaryString(-a << 1));
        System.out.println(Integer.toBinaryString(a));
    }

    @Test
    public void test5() {
        int q = 25;
        // really: r = i - (q * 100);
        System.out.println((q << 6) + (q << 5) + (q << 2));
    }

    @Test
    public void test() {

        List<String> abscissa = new ArrayList<>();
        DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endLocalDate = LocalDate.now();
        LocalDate startLocalDate = LocalDate.now().minusYears(1);
        Period periodDay = Period.between(startLocalDate, endLocalDate);
//        for (long i = 0; i < periodDay.getDays(); i++) {
//            abscissa.add(dayFormat.format(startLocalDate.plusDays(i)));
//        }
//        System.out.println(abscissa);
        System.out.println(endLocalDate.getMonth().getValue() - startLocalDate.getMonth().getValue());

        long between = ChronoUnit.MONTHS.between(startLocalDate, endLocalDate);
        System.out.println(between);

        System.out.println("1111111");
    }

}
