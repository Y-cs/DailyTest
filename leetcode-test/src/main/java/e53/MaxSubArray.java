package e53;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/8 17:52
 * @Description:
 **/
public class MaxSubArray {
    //    b & ((a-b) >> 31) | a & (~(a-b) >> 31)
    public int maxSubArray(int[] nums) {
        int pre = 0, ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = nums[i] & (pre >> 31) | pre + nums[i] & (~pre >> 31);
            ans = pre & ((ans - pre) >> 31) | ans & (~(ans - pre) >> 31);
        }
        return ans;
    }


}
