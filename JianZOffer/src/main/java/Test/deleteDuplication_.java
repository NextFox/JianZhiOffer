package main.java.Test;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @Desc:
 * @Date: 2019/1/23 10:50  better late than never. 认真思考，不要直接就动手写
 */
public class deleteDuplication_ {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode phead = new ListNode(1);
        phead.next = new ListNode(2);
        phead.next.next = new ListNode(3);
        phead.next.next.next = new ListNode(3);
        phead.next.next.next.next = new ListNode(4);
        phead.next.next.next.next.next = new ListNode(4);
        phead.next.next.next.next.next.next = new ListNode(5);

        ListNode res = deleteDuplication(phead);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    //1->2->3->3->4->4->5
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode preNode = null;
        ListNode node = pHead;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                int value = node.val;
                while (node.next != null && node.next.val == value) {
                    node = node.next;
                }
                if (preNode == null)
                    pHead = node.next;
                else
                    preNode.next = node.next;
            } else
                preNode = node;
            node = node.next;
        }
        return pHead;
    }


/*
    如何解决数组向单链表赋值的问题  方案一 gg
    public static ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null) return pHead;
        ListNode front = pHead;
        StringBuffer stringBuffer = new StringBuffer();
        int count[] = new int[1000004];
        while (front != null) {
            stringBuffer.append(front.val + "");
            ++count[front.val];
            front = front.next;
        }

        String str = stringBuffer.toString();
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i) - '0'] > 1)
                str = str.replaceAll(str.charAt(i) - '0' + "", "");
        }


        ListNode root = null;
        return null;
    }
*/

}
