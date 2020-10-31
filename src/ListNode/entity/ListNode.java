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

    public ListNode setNextNode(ListNode node){
        ListNode curr = this;
        curr = this;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = node;
        return this;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.setNextNode(new ListNode(3)).setNextNode(new ListNode(44));
        System.out.println(node);
    }
}
