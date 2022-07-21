package base;

import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/10 14:59
 * @Description:
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
