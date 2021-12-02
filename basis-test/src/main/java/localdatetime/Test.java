package localdatetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/10/15 11:24
 * @Description:
 **/
public class Test {


    public static void main(String[] args) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-01-01");
        LocalDate parse = LocalDate.parse("2020", dateTimeFormatter);
        System.out.println(parse);
    }

}
