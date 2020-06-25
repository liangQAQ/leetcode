package sort;


import ListNode.entity.ListNode;

public class 链表实现快排 {
    public static void main(String[] args) {
        ListNode a = new ListNode(-1);
        a.next = new ListNode(5);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(0);
        System.out.println(a);
        System.out.println(insertionSortList(a));
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        while(head!=null){
            ListNode curr = new ListNode(head.val) ;
            if(result.next==null){
                result.next = curr;
            }else{
                ListNode resultCurr = result;
                while(result!=null){
                    if(resultCurr.next==null){
                        resultCurr.next = curr;
                        break;
                    }else if(curr.val>resultCurr.val&&curr.val<resultCurr.next.val){
                        curr.next = resultCurr.next;
                        resultCurr.next = curr;
                        break;
                    }
                    resultCurr = resultCurr.next;
                }
            }

            head = head.next;
        }

        return result.next;
    }
}
