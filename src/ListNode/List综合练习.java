package ListNode;

import ListNode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class List综合练习 {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);

        node.setNextNode(new ListNode(1))
                .setNextNode(new ListNode(2))
                .setNextNode(new ListNode(3))
                .setNextNode(new ListNode(4))
                .setNextNode(new ListNode(5))
        ;

        System.out.println(sort(node));
    }


    public static ListNode sort(ListNode node){
        List<ListNode> list = sliceList(node);
        ListNode l1 = list.get(0);
        //将第二个链表翻转
        ListNode l2 = list.get(1);
        l2 = reverseList(list.get(1));
//        System.out.println(l1);
        //遍历拼接两个链表  （l1 长度大于等于 l2）
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while(l1!=null){
            curr.next = l1 ;
            curr = curr.next;
            l1 = l1.next;
            if(l2!=null){
                curr.next = l2 ;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        return result.next;
    }

    /**
     * 使用快慢指针切割链表
     * @param head
     * @return
     */
    public static List<ListNode> sliceList(ListNode head) {
        List<ListNode> result = new ArrayList<>();
        if(head == null || head.next == null){
            return null;
        }
        //利用快慢指针找到中间节点
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);
        slow.next = head;
        fast.next = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right;
        if(fast.next!=null){//还多一个
            right = slow.next.next;//第一个链表多截取一位。
            slow.next.next = null;//找到中间位置，切断
        }else{//刚好平分
            right = slow.next;
            slow.next = null;//找到中间位置，切断
        }
        result.add(left);
        result.add(right);
        System.out.println(result);
        return result;
    }
//            1 2 3 4 5
            //1 2 3 4 5
    /**
     * 使用头插法翻转链表
     * @param head
     * @return
     */
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

}
