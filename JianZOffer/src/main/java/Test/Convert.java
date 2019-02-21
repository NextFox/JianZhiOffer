package main.java.Test;

/**
 * @desc:
 * @Date: 2019/1/19 18:33
 */
public class Convert {


    public static TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastNode = null;
        TreeNode headNode = ConvertNode(pRootOfTree, lastNode);
        while (headNode != null && headNode.left != null)
            headNode = headNode.left;
        return headNode;

    }

    static TreeNode ConvertNode(TreeNode root, TreeNode lastNode) {

        if (root == null) return null;

        if (root.left != null)
            lastNode = ConvertNode(root.left, lastNode);

        root.left = lastNode;
        if (lastNode != null) lastNode.right = root;

        lastNode = root;
        if (root.right != null)
            lastNode = ConvertNode(root.right, lastNode);
        return lastNode;

    }

    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


/*

    public static TreeNode Convert(TreeNode pRootOfTree) {

        TreeNode lastNode = null;
        TreeNode headNode = ConvertNode(pRootOfTree, lastNode);
        while (headNode != null && headNode.left != null) headNode = headNode.left;

        return headNode;
    }

    static TreeNode ConvertNode(TreeNode root, TreeNode lastNode) {
        if (root == null) return null;

        if (root.left != null)
            lastNode = ConvertNode(root.left, lastNode);

        root.left = lastNode;
        if (lastNode != null) lastNode.right = root;

        lastNode = root;
        if (root.right != null)
            lastNode = ConvertNode(root.right, lastNode);
        return lastNode;
    }
*/

}
