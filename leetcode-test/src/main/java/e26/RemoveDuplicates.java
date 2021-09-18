package e26;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/6 11:00
 * @Description:
 **/
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int ans = 0;
        int invalid = nums.length;
        while (ans != invalid) {
            boolean reverse = false;
            for (int i = 0; i < ans; i++) {
                if (nums[ans] == nums[i]) {
                    invalid--;
                    reverse = true;
                    nums[ans] = nums[ans] ^ nums[invalid];
                    nums[invalid] = nums[ans] ^ nums[invalid];
                    nums[ans] = nums[ans] ^ nums[invalid];
                    break;
                }
            }
            if (!reverse) {
                ans++;
            }
        }
        return ans;
    }


    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int next = 1;
        while (next != nums.length) {
            if (nums[ans] == nums[next++]) {
                for (int j = next; j < nums.length; j++) {
                    if (nums[j] != nums[ans]) {
                        ans++;
                        nums[ans] = nums[j];
                        next = j;
                        break;
                    }
                }
            }else{
                ++ans;
            }
        }
        return ++ans;
    }

}
