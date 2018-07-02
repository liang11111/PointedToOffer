package linkedList;

public class P142_ReverseList {
    public ListNode ReverList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode Node = head;
        ListNode ReverseHead = null;
        ListNode PreNode = null;

        while(Node != null){
            ListNode NextNode = Node.next;
            if(Node.next == null){
                ReverseHead = Node;
            }

            Node.next = PreNode;

            PreNode = Node;
            Node = NextNode;

        }
        return ReverseHead;
    }
}
