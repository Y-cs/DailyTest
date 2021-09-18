package e15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/13 15:49
 * @Description:
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j = 0, k = 0;
        while (i < nums.length) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int value1 = nums[i];
            j = i + 1;
            while (j < nums.length - 1) {
                if (j >= i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int value2 = nums[j];
                k = j + 1;
                while (k < nums.length) {
                    if (value1 + value2 == -nums[k]) {
                        result.add(Arrays.asList(value1, value2, nums[k]));
                    }
                    k++;
                }
                j++;
            }
            i++;
        }


        return result;
    }
}
