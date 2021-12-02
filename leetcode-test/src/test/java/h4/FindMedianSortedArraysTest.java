package h4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/28 14:31
 * @Description:
 **/
class FindMedianSortedArraysTest {

    FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();

    @Test
    public void test1() {
//        double msa1 = findMedianSortedArrays.findMedianSortedArrays(new int[]{0, 0, 0}, new int[]{0, 0});
//        assert msa1 == 0;
        double msa2 = findMedianSortedArrays.findMedianSortedArrays(new int[]{0}, new int[]{2, 3, 4, 5, 6});
        assert msa2 == 3.5D;
        double msa3 = findMedianSortedArrays.findMedianSortedArrays(new int[]{1}, new int[]{});
        assert msa3 == 1D;
        double msa4 = findMedianSortedArrays.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        assert msa4 == 2D;

    }

}