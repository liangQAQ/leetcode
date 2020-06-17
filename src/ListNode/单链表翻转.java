package ListNode;

import ListNode.entity.ListNode;

/**
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 头插法/尾部递归
 */
public class 单链表翻转 {
    public static ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(0);

        while(head!=null){
            ListNode currSingle = new ListNode(head.val);
            if(result.next==null){
                result.next = currSingle;
            }else{
                currSingle.next = result.next;
                result.next = currSingle;
            }
            head = head.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(5);
        System.out.println(l1);
        System.out.println(reverseList(l1));
    }
}
