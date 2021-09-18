package e27;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/6 15:00
 * @Description:
 **/
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int first = 0, last = nums.length - 1;

        while (first <= last) {
            if (nums[first] == val) {
                while (first <= last) {
                    if (nums[last]!=val){
                        nums[first]=nums[last];
                        last--;
                        first++;
                        break;
                    }
                    last--;
                }
            }else{
                first++;
            }
        }

        return first;
    }

}
