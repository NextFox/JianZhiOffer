package main.java.Test;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc:
 * @Date: 2019/2/1 19:06  better late than never. 认真思考，不要直接就动手写
 * <p>
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 定义一个flag看他所在行数，奇数行从左到右，偶数行取反从右到左
 * 设置一个反转函数，偶数行反转
 * 定义一个队列实现对层次遍历的存储
 * 设置一个开始与结束标志，当start==end时，一行读入完毕
 */
public class PrintBiTree {


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> nodelist = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean isLeftToRight = true;
        int start = 0, end = 1;

        if (pRoot == null) return nodelist;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            start++;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            if (start == end) {
                if (!isLeftToRight) nodelist.add(revers(result));
                else nodelist.add(result);

                //下一行需要改变方向
                isLeftToRight = !isLeftToRight;
                end = queue.size();
                start = 0;
                result = new ArrayList<Integer>();
            }
        }
        return nodelist;
    }

    static ArrayList<Integer> revers(ArrayList<Integer> result) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            res.add(result.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        ArrayList<ArrayList<Integer>> list = new PrintBiTree().Print(root);
        for (ArrayList<Integer> arrayList : list) {
            System.out.println(arrayList);
        }
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
