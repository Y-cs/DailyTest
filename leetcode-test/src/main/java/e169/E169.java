package e169;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/18 11:19
 * @Description:
 **/
public class E169 {

    public int majorityElement(int[] nums) {

        int temp=0;
        int count=0;

        for (int num : nums) {
            if (count==0) {
                temp=num;
            }
            count+=(temp==num)?1:-1;
        }
        return temp;
    }

}
