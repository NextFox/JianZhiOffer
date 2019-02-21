package main.java.Test;

import java.util.ArrayList;

/**
 * @Desc:
 * @Date: 2019/2/7 9:56  better late than never. 认真思考，不要直接就动手写
 */
public class KthNode_ {

    static int index = 0;

    static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) return node;
            index++;
            if (index == k) return pRoot;
            node = KthNode(pRoot.right, k);
            if (node != null) return node;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(8);
        s.left = new TreeNode(6);
        s.right = new TreeNode(10);
        s.left.left = new TreeNode(5);
        s.left.right = new TreeNode(7);
        s.right.left = new TreeNode(9);
        s.right.right = new TreeNode(11);

        System.out.println(KthNode(s, 1).val);
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
