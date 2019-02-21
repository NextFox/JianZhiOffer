package main.java.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc:
 * @Date: 2019/2/2 10:48  better late than never. 认真思考，不要直接就动手写
 * <p>
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 定义一个用于存储列表的列表和一个用于处理数据的列表
 * 定义一个LikedList用来处理数据
 * 定义start、end来判断一行是否结束
 */
public class PrintBiTreeTwo {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> resultlist = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int start = 0, end = 1;

        queue.add(pRoot);
        if (pRoot == null) return resultlist;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            result.add(currentNode.val);
            start++;
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
            if (start == end) {
                resultlist.add(result);
                start = 0;
                end = queue.size();
                result = new ArrayList<Integer>();
            }
        }
        return resultlist;
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
