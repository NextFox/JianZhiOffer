package main.java.Test;

/**
 * @Desc:
 * @Date: 2019/1/23 9:45  better late than never. 认真思考，不要直接就动手写
 */
public class EntryNodeOfLoop_ {

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null) return null;
        ListNode front = pHead;
        ListNode fallow = pHead;
        while (front.next != null) {
            front = front.next;
            fallow.next = null;
            fallow = front;
        }
        return front;
    }
}
