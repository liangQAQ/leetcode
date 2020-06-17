package ListNode.entity;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode() {  }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while (curr!=null){
            sb.append(curr.next!=null?curr.val+"->":curr.val);
            curr = curr.next;
        }
        return sb.toString();
    }
}
