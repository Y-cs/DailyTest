package m17;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/16 11:05
 * @Description:
 **/
public class LetterCombinations {

    String[] cache = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        char[] nums = digits.toCharArray();
        List<String> result = new ArrayList<>();
        for (char num : nums) {
            String str = cache[Integer.parseInt(Character.toString(num))-1];
            if (str.length()!=0) {
                List<String> newResult = new ArrayList<>();
                char[] chars = str.toCharArray();
                for (char c : chars) {
                    if (result.size()==0) {
                        newResult.add(Character.toString(c));
                    }else{
                        for (String s : result) {
                            newResult.add(s + c);
                        }
                    }
                }
                result = newResult;
            }
        }
        return result;
    }



}
