package ListNode;

import ListNode.entity.ListNode;

/**
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 每一次都是选择两个链表中较小的头结点，然后继续merge
 */
public class 合并两个有序链表 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode result = new ListNode();
        head.next = result;
        merge(l1,l2,result);
        return head.next.next;
    }

    public static void merge(ListNode l1, ListNode l2,ListNode result){
        if(l1 == null&&l2 == null){
            return ;
        }

        if(l1 == null){
            result.next = l2;
            return ;
        }

        if(l2 == null){
            result.next = l1;
            return ;
        }

        ListNode temp = new ListNode();
        if(l1.val<=l2.val){
            temp = l1;
            l1 = l1.next;
            temp.next = null;
        }else{
            temp = l2;
            l2 = l2.next;
            temp.next = null;
        }
        result.next = temp;
        result = result.next;
        merge(l1,l2,result);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(mergeTwoLists(l1,l2));
    }
}
