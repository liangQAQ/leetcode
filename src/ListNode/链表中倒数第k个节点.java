package ListNode;

import ListNode.entity.ListNode;

/**
 * 快慢链表相隔K个位置，一起向后遍历，当快链表到末尾时，返回慢链表即可
 */
public class 链表中倒数第k个节点 {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while(k>1){
            if(fast==null){
                return fast;
            }
            fast = fast.next;
            k--;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
