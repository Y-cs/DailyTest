package m1797;

import org.junit.jupiter.api.Test;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/15 18:14
 * @Description:
 **/
class AuthenticationManagerTest {

    @Test
    public void test1(){
        AuthenticationManager authenticationManager = new AuthenticationManager(5);
        authenticationManager.renew("aaa",1);
        authenticationManager.generate("aaa",2);
        authenticationManager.countUnexpiredTokens(6);
    }

}