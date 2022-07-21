package e191;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/11 17:32
 * @Description:
 **/
public class E191 {

    public int hammingWeight(int n) {
        int r = 0;
        while (n != 0) {
            if ((n&1)>0) {
                r++;
            }
            n=n>>>1;
        }
        return r;
    }

}
