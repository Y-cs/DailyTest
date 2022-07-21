package m15;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/7 9:41
 * @Description:
 **/
public class M15 {

    public List<List<Integer>> threeSum(int[] nums) {
        new ThreadPoolExecutor(1,1,1, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        return null;
    }


}
