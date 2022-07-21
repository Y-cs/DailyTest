package s258;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/3 16:21
 * @Description:
 **/
public class S258 {

    public int addDigits(int num) {
        if (num==0) {
            return 0;
        }
        int result=0;
        while (num!=0){
            result+=num%10;
            num/=10;
        }
        if (result>9) {
            result=addDigits(result);
        }
        return result;
    }

    public static void main(String[] args) {
        S258 s258 = new S258();
        System.out.println(s258.addDigits(1238));
    }

}
