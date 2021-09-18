package m17;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/16 13:52
 * @Description:
 **/
class LetterCombinationsTest {

    @Test
    public void test1(){
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("212");
        System.out.println(strings);
    }

}