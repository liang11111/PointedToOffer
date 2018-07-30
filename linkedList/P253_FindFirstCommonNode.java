package linkedList;

//输入两个链表，找出它们的第一个公共结点。

public class P253_FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //求两个链表的长度
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);
        if (length1 == 0 || length2 == 0) {
            return null;
        }

        int dif = Math.abs(length1 - length2);

        //区别长链表和短链表
        ListNode pointLongList = null;
        ListNode pointShortList = null;

        if (length1 > length2) {
            pointLongList = pHead1;
            pointShortList = pHead2;
        } else {
            pointLongList = pHead2;
            pointShortList = pHead1;
        }

        //长链表先走dif步
        for (int i = 0; i < dif; i++) {
            pointLongList = pointLongList.next;
        }

        while (pointLongList != null && pointShortList != null & pointLongList != pointShortList) {
            pointLongList = pointLongList.next;
            pointShortList = pointShortList.next;
        }
        return pointLongList;
    }

    public int getLength(ListNode phead1){
        if (phead1 == null) {
            return 0;
        }
        ListNode phead = phead1;
        int length = 0;
        while (phead.next!=null) {
            phead = phead.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode phead1=new ListNode();
        ListNode phead2 = new ListNode();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        phead1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;
        node7.next = null;

        phead2.next = node4;
        node4.next = node5;
        node5.next = node6;

        P253_FindFirstCommonNode test = new P253_FindFirstCommonNode();
        ListNode result = test.FindFirstCommonNode(phead1,phead2);
        System.out.println(result.val);

    }

}
