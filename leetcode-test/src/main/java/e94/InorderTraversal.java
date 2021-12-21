package e94;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/7 16:41
 * @Description:
 **/
public class InorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode node, List<Integer> ints) {
        if (node == null) {
            return;
        }
        inorder(node.left, ints);
        ints.add(node.val);
        inorder(node.right, ints);
    }

}
