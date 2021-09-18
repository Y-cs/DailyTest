package e35;

import org.junit.jupiter.api.Test;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/9 10:06
 * @Description:
 **/
class SearchInsertTest {

    private SearchInsert searchInsert=new SearchInsert();

    @Test
    void searchInsert() {
        int i = searchInsert.searchInsert(new int[]{1, 2, 3, 4, 5}, 2);
        System.out.println(i);
    }
    @Test
    void searchInsert1() {
        int i = searchInsert.searchInsert(new int[]{2}, 2);
        System.out.println(i);
    }
    @Test
    void searchInsert2() {
        int i = searchInsert.searchInsert(new int[]{2,3,4,5}, 1);
        System.out.println(i);
    }
    @Test
    void searchInsert5() {
        int i = searchInsert.searchInsert(new int[]{2,3,4,5}, 7);
        System.out.println(i);
    }
    @Test
    void searchInsert6() {
        int i = searchInsert.searchInsert(new int[]{2,3,5,5}, 4);
        System.out.println(i);
    }
}