package array;

import entity.ListNode;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 逐位相加，进位next+1
 */
public class ListNodeSum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = null;
        int flag = 0;//进位
        while(l1!=null&&l2!=null){
            ListNode nextNode = new ListNode(0);
            int sum = l1.val+l2.val+flag;
            nextNode.val = sum % 10;
            if(sum>=10){
                flag = 1;
            }else{
                flag = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            if(sumNode == null){
                sumNode = nextNode;
            }else{
                sumNode.next = nextNode;
            }
        }
        return sumNode;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = new ListNode(0);
        dummyHead = curr;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode sum = addTwoNumbers1(l1,l2);
    }
}
