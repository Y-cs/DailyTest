package wx.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/16 17:07
 * @Description:
 **/
@ConfigurationProperties(prefix = "wx")
@Getter
@Setter
public class WxConfig {

    private static final String ACCESS_TOKEN_CACHE_KEY = "WX_CACHE:ACCESS_TOKEN";

    private Url url = new Url();

    private String appId;

    private String secret;

    static class Url {
        private String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
        private String pushTemplateMsgUrl = "https://api.weixin.qq.com/cgi-bin/token";
    }


    public String getCacheKey() {
        return ACCESS_TOKEN_CACHE_KEY;
    }

}
