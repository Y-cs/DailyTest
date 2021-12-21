package rabbit.test.service.hashring;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/10 14:53
 * @Description:
 **/
public class HashRing {

    private List<String> keys = Arrays.asList("node1", "node2", "node3");

    private TreeMap<Integer, String> nodes = new TreeMap<>();

    public void get() {
        for (String key : keys) {
            for (int i = 0; i < 1000; i++) {
                String name = key + i;
                nodes.put(key.hashCode(), key);
            }
        }
    }


}
