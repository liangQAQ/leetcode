package ListNode;

import ListNode.entity.ListNode;

/**
 * 利用快慢指针找到中间节点并切割
 */
public class 二分法切割合并链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(4);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        System.out.println(l1);
        System.out.println(sortList(l1));
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //利用快慢链表找到中间节点
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);
        slow.next = head;
        fast.next = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;

        return merge(sortList(left),sortList(right));
    }

    public static ListNode merge(ListNode l1,ListNode l2){
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(true){
            if(l1==null){
                result.next = l2;
                break;
            }
            if(l2==null){
                result.next = l1;
                break;
            }
            if(l1.val <= l2.val){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }
        return head.next;
    }
}
