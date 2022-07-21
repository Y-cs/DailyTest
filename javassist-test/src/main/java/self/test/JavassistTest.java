package self.test;

import javassist.*;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/1/5 17:40
 * @Description:
 **/
public class JavassistTest {

    public void updatePrint() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
        ClassPool aDefault = ClassPool.getDefault();
        CtClass ctClass = aDefault.get("java.io.PrintStream");
        CtMethod println = ctClass.getDeclaredMethod("println", new CtClass[]{aDefault.get("java.lang.String")});
        println.insertBefore("$1+=\"1\";");
        PrintStream o = (PrintStream) ctClass.toClass().newInstance();
        System.setOut(o);
    }

    @Test
    public void test1() throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException {
        updatePrint();
        System.out.println("aa");
    }

}
