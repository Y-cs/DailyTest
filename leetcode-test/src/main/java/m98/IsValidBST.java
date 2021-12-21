package m98;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/12/7 17:24
 * @Description:
 **/
public class IsValidBST {

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

    public boolean isValidBST(TreeNode root) {
        return recursion(root);
    }

    private boolean recursion(TreeNode root) {
        if (root == null) {
            return true;
        }
//        recursion(t)
        return false;
    }


}
