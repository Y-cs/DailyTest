package file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/9 9:48
 * @Description:
 **/
public class FilePathTest {

    @Test
    public void test1() throws IOException {

        File file = new File("aaa/file");

        System.out.println(file.getCanonicalPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());


    }



}
