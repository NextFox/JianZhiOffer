package main.java.Test;

/**
 * @Desc:
 * @Date: 2019/2/1 18:54  better late than never. 认真思考，不要直接就动手写
 *
 * 分析:首先判断这棵树是不是空树以及是否只是根节点。如果满足则是是对称树。左右子树不同时为空时不是
 *
 * 如果不是上述情况，就要递归遍历树的每个节点
 * (左子树中每个节点的左孩子 = 同层右子树中每个节点的右孩子 && 左子树中每个节点的右孩子 = 同层右子树中每个节点的左孩子)
 */
public class isSymmetrical_ {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null || pRoot.left == null && pRoot.right == null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val)
            return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
        return false;
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
