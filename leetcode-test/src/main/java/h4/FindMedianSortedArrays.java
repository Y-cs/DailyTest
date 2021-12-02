package h4;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/28 14:18
 * @Description:
 **/
public class FindMedianSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return length1 == 0 ? nums2[0] : nums1[0];
        }
        //中位数位置
        int num = length / 2 + 1;
        //双指针
        int p1 = 0, p2 = 0;
        //结果窗口
        int[] ints = new int[2];
        //滑动
        for (int i = 0; i < num; i++) {
            if (p1 == length1) {
                updateArray(ints, nums2[p2++]);
            } else if (p2 == length2) {
                updateArray(ints, nums1[p1++]);
            } else if (nums1[p1] < nums2[p2]) {
                updateArray(ints, nums1[p1++]);
            } else {
                updateArray(ints, nums2[p2++]);
            }
        }
        if ((length & 1) == 1) {
            //奇数
            return ints[1];
        } else {
            return ((double) ints[0] + (double) ints[1]) / (double) 2;
        }
    }

    private void updateArray(int[] ints, int num) {
        ints[0] = ints[1];
        ints[1] = num;
    }

}
