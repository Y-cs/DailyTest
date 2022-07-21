package wx.holder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import okhttp3.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;
import wx.config.WxConfig;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/15 13:15
 * @Description:
 **/
@RequiredArgsConstructor
public class AccessTokenHolder {

    private final RestTemplate restTemplate;

    private final RedisTemplate<String,String> redisTemplate;

    private final WxConfig wxConfig;

    public String getAccessToken(){
        String accessToken = redisTemplate.opsForValue().get(wxConfig.getCacheKey());
        if (accessToken==null) {
            refreshToken();
        }
        return accessToken;
    }

    @SneakyThrows
    public void refreshToken() {
        //HttpUrl.Builder builder = HttpUrl.get("https://api.weixin.qq.com/cgi-bin/token").newBuilder();
        //builder.addQueryParameter("grant_type","client_credential");
        //builder.addQueryParameter("appid","wx75d405a320892c45");
        //builder.addQueryParameter("secret","29da04c618e79043451135390d992658");
        //Request request = new Request.Builder().url(builder.build()).get().build();
        //Response execute = client.newCall(request).execute();
        //if (execute.isSuccessful()) {
        //    ResponseBody body = execute.body();
        //    System.out.println(body);
        //    JSONObject jsonObject = JSON.parseObject(body.string());
        //    accessToken=jsonObject.getString("access_token");
        //    failureTime=jsonObject.getLong("expires_in")-advanceGet;
        //}
        
    }


}
