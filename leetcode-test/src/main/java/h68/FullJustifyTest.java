package h68;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/10 13:55
 * @Description:
 **/
class FullJustifyTest {

    @Test
    void fullJustify() {

        FullJustify fullJustify = new FullJustify();
        List<String> strings = fullJustify
                .fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to",
                        "explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
        for (String string : strings) {
            System.out.println(string);
        }

    }
    @Test
    void fullJustify2() {

        FullJustify fullJustify = new FullJustify();
        /**
         * ["The","important","thing","is","not","to","stop","questioning.","Curiosity","has","its","own","reason","for","existing."]
         * 17
         */
        List<String> strings = fullJustify
                .fullJustify(new String[]{"The","important","thing","is","not","to","stop","questioning.","Curiosity","has","its","own","reason","for","existing."}
                        , 17);
        for (String string : strings) {
            System.out.println(string);
        }
//["The     important","thing  is  not to","stop questioning.","Curiosity has its","own   reason  for","existing.        "]
    }
}