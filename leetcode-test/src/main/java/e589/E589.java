package e589;

import base.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2022/3/10 14:59
 * @Description:
 **/
public class E589 {

    public List<Integer> preorder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        doPreorder(root,result);
        return result;
    }

    private void doPreorder(Node node, List<Integer> list) {
        list.add(node.val);
        List<Node> children = node.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                doPreorder(child,list);
            }
        }
    }

}
