package ListNode;

import ListNode.entity.ListNode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class 单链表翻转2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNextNode(new ListNode(2))
                .setNextNode(new ListNode(3))
                .setNextNode(new ListNode(4))
                .setNextNode(new ListNode(5));
        System.out.println(listNode);
        System.out.println(reverseBetween(listNode,2,4));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode currNode = new ListNode(0);
        ListNode result = currNode;
        int currCount = 1;
        ListNode single = null;
        while(head!=null){
            single = new ListNode(head.val);
            if(currCount<m){
                currNode.next = single;
                currNode = currNode.next;
            }else if(currCount>=m && currCount<=n){
                //头插法
                if(currNode.next==null){
                    currNode.next = single;
                }else{
                    single.next = currNode.next;
                    currNode.next = single;
                }
            }else{
                //移动到末端
                while(currNode.next!=null){
                    currNode = currNode.next;
                }
                currNode.next = single;
                currNode = currNode.next;
            }
            head = head.next;
            currCount++;
        }

        return result.next;
    }

}
