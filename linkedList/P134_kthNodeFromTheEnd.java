package linkedList;

public class P134_kthNodeFromTheEnd {
    public static ListNode FindKthToTail(ListNode head, int k){
        if(head == null || k == 0){
            return null;
        }
        ListNode head1 = head;
        ListNode head2 = head;
        for(int i = 0; i < k-1; i++){
            if(head1.next != null){
                head1 = head1.next;
            }
            else
                return null;
        }

        while(head1.next != null){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head2;
    }


}
