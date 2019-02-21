package main.java.Test;


import java.util.ArrayList;

/**
 * @Desc:
 * @Date: 2019/1/21 10:21  better late than never. 认真思考，不要直接就动手写
 */
public class TreeDepth_ {
    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(TreeDepth(root));
    }

    public static int TreeDepth(TreeNode root) {
        if (root == null) return 0;

        int left =TreeDepth(root.left);
        int right = TreeDepth(root.right);

        if(left>right)return left+1;
        else return right+1;

    }


}
