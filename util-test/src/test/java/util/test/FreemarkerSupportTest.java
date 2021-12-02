package util.test;


import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import util.model.DocumentDto;

import java.io.IOException;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/10/11 18:03
 * @Description:
 **/
public class FreemarkerSupportTest {

    @Test
    public void test1() throws TemplateException, IOException {
        FreemarkerSupport freemarkerSupport = new FreemarkerSupport("D:\\Self\\DailyTest\\util-test\\",
                "template.ftl");
        DocumentDto documentDto = new DocumentDto();
        documentDto.setTitle("this is title");
        freemarkerSupport.writeHtml("aaa", documentDto);
    }


}