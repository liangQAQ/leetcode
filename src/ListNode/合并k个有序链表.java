package ListNode;

import ListNode.entity.ListNode;

import java.util.Arrays;

/**
 * 分治法，头尾逐个合并
 */
public class 合并k个有序链表 {
    public static ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length==0){
            return null;
        }
        if(length == 1){
            return lists[0];
        }
        for(int i =0;i<lists.length/2;i++){
            lists[i] = merge2Node(lists[i],lists[length-1-i]);
        }
        return mergeKLists(Arrays.copyOf(lists,(length+1)/2));
    }

    public static ListNode merge2Node(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        ListNode curr = result;
        while(true){
            if(l1==null&&l2==null){
                return result.next;
            }
            if(l1==null){
                curr.next = l2;
                return result.next;
            }
            if(l2==null){
                curr.next = l1;
                return result.next;
            }
            if(l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next=new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next = new ListNode(6);
        ListNode l3 = new ListNode(2);
        l3.next=new ListNode(6);
        ListNode[] lists = {l1,l2,l3};
        System.out.println(mergeKLists(lists));
    }
}
