package e27;



import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/6 15:22
 * @Description:
 **/
public class RemoveElementTest {

    private int[] array=new int[]{2, 3, 4, 5, 6};

    @Test
    public void test1(){
        RemoveElement removeElement = new RemoveElement();
        int i = removeElement.removeElement(array, 2);
        System.out.println(i);
        System.out.println(Arrays.toString(array));
    }
    @Test
    public void test2(){
        RemoveElement removeElement = new RemoveElement();
        array=new int[]{3,2,2,3};
        int i = removeElement.removeElement(array, 3);
        System.out.println(i);
        System.out.println(Arrays.toString(array));
    }
    @Test
    public void test3(){
        RemoveElement removeElement = new RemoveElement();
        array=new int[]{3,3,3,3};
        int i = removeElement.removeElement(array, 3);
        System.out.println(i);
        System.out.println(Arrays.toString(array));
    }
    @Test
    public void test4(){
        RemoveElement removeElement = new RemoveElement();
        array=new int[]{3};
        int i = removeElement.removeElement(array, 3);
        System.out.println(i);
        System.out.println(Arrays.toString(array));
    }

}