package security.service;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/27 17:28
 * @Description:
 **/
public class ApproveManager implements Customizer<FormLoginConfigurer<HttpSecurity>> {
    @Override
    public void customize(FormLoginConfigurer<HttpSecurity> httpSecurityFormLoginConfigurer) {

    }
}
