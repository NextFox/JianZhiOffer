package main.java.Test;

/**
 * @Desc:
 * @Date: 2019/1/21 11:33  better late than never. 认真思考，不要直接就动手写
 */
public class IsBalanced {
    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {

        if (root == null) return true;

        int left = deepth(root.left);
        int right = deepth(root.right);

        int diff = left - right;
        if (diff > 1 || diff < -1) return false;

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    static int deepth(TreeNode root) {
        if (root == null) return 0;

        int left = deepth(root.left);
        int right = deepth(root.right);
        if (left > right) return left + 1;
        else return right + 1;
    }
}
