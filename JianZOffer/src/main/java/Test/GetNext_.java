package main.java.Test;

/**
 * @desc:
 * @Date: 2019/1/20 11:48
 *
 * 他说要找到中序遍历下的下一个节点。这个节点可以分为两种情况
 *
 * 该节点有右子树
 * 该节点没有右子树
 *
 *
 * 第一种比较处理起来比较简单，直接将其右节点进行中序遍历即可，并将一个遍历到的最右节点返回。
 * 第二种情况又分为两种情况
 *
 * 该节点是父节点的左子节点
 * 该节点是父节点的右子节点
 *
 *
 * 这里，该节点是父节点的左子节点的这种情况比较简单，直接将父节点返回即可
 * 如果是父节点的右子节点的话，需要不断的向上移动，直到对应的节点不是父节点的右节点（即左节点），
 * 既然他是父节点的左节点，此时将这个节点父节点返回即可，或者遍历到了根节点，返回null；
 */
public class GetNext_ {

    public static void main(String[] args) {

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
