package e700;

/**
 * @Author: YuanChangShuai
 * @Date: 2021/11/26 17:37
 * @Description:
 **/
public class SearchBST {

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


    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode rightNode = searchBST(root.right, val);
        if (rightNode != null) {
            return rightNode;
        }
        TreeNode leftNode = searchBST(root.left, val);
        if (leftNode != null) {
            return leftNode;
        }
        return null;
    }

    public static void main(String[] args) {

    }


}
