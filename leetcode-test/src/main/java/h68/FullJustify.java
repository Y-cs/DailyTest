package h68;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/10 13:27
 * @Description:
 **/
public class FullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new LinkedList<>();
        int width = 0;
        List<String> pen = new LinkedList<>();
        for (String word : words) {
            if (width + pen.size() - 1 + word.length() < maxWidth) {
                pen.add(word);
                width += word.length();
            } else {
                int spaceNum = maxWidth - width;
                StringBuilder result = new StringBuilder(pen.get(0));
                StringBuilder spaceOne = new StringBuilder();
                if (pen.size() == 1) {
                    for (int i = 0; i < spaceNum; i++) {
                        result.append(" ");
                    }
                } else {
                    for (int i = 0; i < spaceNum / (pen.size() - 1); i++) {
                        spaceOne.append(" ");
                    }
                    int excess = spaceNum - (spaceOne.length() * (pen.size() - 1));
                    for (int i = 1; i < pen.size(); i++) {
                        if (--excess >= 0) {
                            result.append(" ");
                        }
                        result.append(spaceOne).append(pen.get(i));
                    }
                }
                ans.add(result.toString());
                width = 0;
                pen.clear();
                pen.add(word);
                width += word.length();
            }
        }
        StringBuilder sb = new StringBuilder(String.join(" ", pen));
        int excess = maxWidth - sb.length();
        for (int i = 0; i < excess; i++) {
            sb.append(" ");
        }
        ans.add(sb.toString());
        return ans;
    }


}
