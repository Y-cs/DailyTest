package wx.controller;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import wx.holder.AccessTokenHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/15 17:28
 * @Description:
 **/
@RestController
public class TestController {

    // TODO 这里的token是微信公众平台上自己所配的！
    private static final String token = "ycs";

    /**
     * 处理微信认证：验证服务器地址的有效性，get提交
     * signature: 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * timestamp 时间戳
     * nonce: 随机数
     * echostr: 随机字符串
     */
    @GetMapping
    @ResponseBody
    public void check(String signature, String timestamp, String nonce, String echostr, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("服务器验证");
        System.out.println(String.format("参数:signature:%s timestamp:%s nonce:%s echostr:%s", signature, timestamp, nonce, echostr));
        response.getWriter().print(echostr);
    }
    private final OkHttpClient client = new OkHttpClient();
    private AccessTokenHolder holder=new AccessTokenHolder();
    @GetMapping("pushmsg")
    public void pushMsg() throws IOException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser","oW8-n5jHFMP8qTYvR7GqIDhyDnsg");
        jsonObject.put("template_id","5Zqsi_a5r-OG41-3D7T24wB3291fykNjYnwJZszii10");
        jsonObject.put("url","");
        jsonObject.put("topcolor","#FF0000");
        JSONObject data = new JSONObject();
        data.put("time", System.currentTimeMillis());
        data.put("data", "aaaaaa");
        jsonObject.put("data",data);

        String json = jsonObject.toJSONString();

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        HttpUrl.Builder builder = HttpUrl.get("https://api.weixin.qq.com/cgi-bin/message/template/send").newBuilder();
        builder.addQueryParameter("access_token",holder.getAccessToken());
        Request request = new Request.Builder().url(builder.build()).post(body).build();
        Response execute = client.newCall(request).execute();
        System.out.println(execute.body().string());
    }

}
