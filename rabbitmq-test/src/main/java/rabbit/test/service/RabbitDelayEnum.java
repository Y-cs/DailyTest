package rabbit.test.service;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/30 17:08
 * @Description:
 **/
public enum RabbitDelayEnum {

    /**
     * 延迟重试等级
     */
    //一秒
    LEVEL1("1000"),
    //三秒
    LEVEL2("3000"),
    //一分钟
    LEVEL3("3000"),
    //十分钟
    LEVEL4("3000"),
    //三十分钟
    LEVEL5("3000"),
    //六小时
    LEVEL6("3000"),
    ;

    private final String time;

    RabbitDelayEnum(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public static RabbitDelayEnum getLevel(int level) {
        RabbitDelayEnum[] values = values();
        return level < 0 || level > values.length - 1 ? null : values[level];
    }
}
