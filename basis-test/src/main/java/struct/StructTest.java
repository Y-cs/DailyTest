package struct;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/2 17:35
 * @Description:
 **/
public class StructTest {

    public static void main(String[] args) {
        String str = "这是一段话，一段很神奇的话";
        //1111 1111 1111 1111
        byte[] bs = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bs));
        byte[] newbs1 = new byte[bs.length];
        byte[] newbs2 = new byte[bs.length];
        for (int i = 0; i < bs.length; i++) {
            newbs1[i] = (byte) (bs[i] >>> 4);
            newbs2[i] = (byte) (bs[i] & 0x0f);
        }
        System.out.println(Arrays.toString(newbs1));
        System.out.println(Arrays.toString(newbs2));
        for (int i = 0; i < newbs1.length; i++) {
            bs[i] = (byte) ((newbs1[i] << 4) | newbs2[i]);
        }
        System.out.println(Arrays.toString(bs));
        System.out.println(new String(newbs1, StandardCharsets.UTF_8));
        System.out.println(new String(newbs2, StandardCharsets.UTF_8));
        System.out.println(new String(bs, StandardCharsets.UTF_8));
    }


}
