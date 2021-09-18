package e35;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/7 16:06
 * @Description:
 **/
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        return doSearch(nums, target, 0, nums.length);
    }

    public int doSearch(int[] nums, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (nums[mid] == target ||
                mid == 0 ||
                mid == nums.length - 1 ||
                (nums[mid - 1] < target && nums[mid + 1] > target)) {
            if (mid == nums.length - 1) {
                return ++mid;
            }
            return mid;
        } else if (nums[mid] > target) {
            return doSearch(nums, target, start, mid);
        } else {
            return doSearch(nums, target, mid, end);
        }
    }

}
