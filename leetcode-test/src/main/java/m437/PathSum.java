package m437;


import base.TreeNode;
import e27.RemoveElement;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/9/28 11:13
 * @Description:
 **/
public class PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        return traverse(root, targetSum);
    }

    /**
     * 遍历整个树
     *
     * @param node
     * @param target
     * @return
     */
    private int traverse(TreeNode node, int target) {
        if (node == null) {
            return 0;
        }
        int result = deepSearch(node, target);
        result += traverse(node.left, target);
        result += traverse(node.right, target);
        return result;
    }

    private int deepSearch(TreeNode node, int target) {
        int result = 0;
        if (node == null) {
            return 0;
        }
        target -= node.val;
        if (target == 0) {
            result++;
        }
        result += deepSearch(node.left, target);
        result += deepSearch(node.right, target);
        return result;
    }

}
