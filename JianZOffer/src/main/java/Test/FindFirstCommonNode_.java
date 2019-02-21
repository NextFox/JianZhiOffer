package main.java.Test;

import java.util.Stack;

/**
 * @Desc: 写代码一点逻辑都没有，都没有认真思考
 * @Date: 2019/1/20 16:05  better late than never.
 */
public class FindFirstCommonNode_ {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(7);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(7);
       // node2.next.next.next = new ListNode(4);
        //node2.next.next.next.next = new ListNode(5);
        ListNode listNode = FindFirstCommonNode(node1, node2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode temp = pHead1;
        Stack<ListNode> stack1 = new Stack();
        Stack<ListNode> stack2 = new Stack();

        if (pHead1 == null) return null;
        if (pHead2 == null) return null;

        while (pHead1 != null ) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null ) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        int pa = 0, pb = 0;
        ListNode result = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            pa = stack1.peek().val;
            pb = stack2.peek().val;
            if (pa != pb) break;
            result = stack1.pop();
            stack2.pop();
            if (stack1.isEmpty() && stack2.isEmpty())
                return temp;
        }
        return result;
    }

}
