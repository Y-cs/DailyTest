package m1797;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/15 18:06
 * @Description:
 **/
public class AuthenticationManager {

    private final Map<String, Integer> cache = new HashMap<>();
    private final int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        cache.put(tokenId, timeToLive + currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer value = cache.get(tokenId);
        if (value != null && value>currentTime) {
            cache.put(tokenId, timeToLive + currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int result = 0;
        for (Integer value : cache.values()) {
            if (currentTime < value) {
                result++;
            }
        }
        return result;
    }

}
