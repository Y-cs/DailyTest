package e136;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/11 17:16
 * @Description:
 **/
public class E136 {

    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0]^=nums[i];
        }
        return nums[0];
    }


}
