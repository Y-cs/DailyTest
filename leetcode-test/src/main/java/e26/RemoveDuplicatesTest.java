package e26;


import org.junit.jupiter.api.*;

import java.util.Arrays;


/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/6 11:43
 * @Description:
 **/
public class RemoveDuplicatesTest {

    private int[] nums = {1, 2};

    @Test
    public void test() {

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
//        nums = new int[]{1, 2,3};
//        nums = new int[]{0,0,0,1,1,1,2,3,4};
//        nums = new int[]{0,0,0,0,0};
        nums = new int[]{0,0,0,0,0,1,1,1,1};
        int i = removeDuplicates.removeDuplicates2(nums);
        System.out.println(i);

    }

    @AfterAll
    public void after() {
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test0() {
        int a = 1, b = 12;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + "," + b);
    }

}