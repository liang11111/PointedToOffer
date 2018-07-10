package linkedList;

public class P187_CopyComplexList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return  null;
        }
        else{
        CloneNode(pHead);
        CloneRandomNode(pHead);
        return ReconnectNode(pHead);
        }
    }

    private   void CloneNode(RandomListNode pHead){
        RandomListNode CloneNode = pHead;
        while (CloneNode != null){
            RandomListNode NowNode = new RandomListNode(CloneNode.label);
            NowNode.next = CloneNode.next;
            CloneNode.next = NowNode;
            CloneNode = NowNode.next;
        }
    }
    private void CloneRandomNode (RandomListNode pHead){
        RandomListNode RandomNode = pHead;
        while (RandomNode != null){

            RandomListNode NextNode = RandomNode.next;
            if(RandomNode.random == null){
                NextNode.random = null;
            }
            else
            NextNode.random = RandomNode.random.next;

            RandomNode = NextNode.next;
        }
    }
    public RandomListNode ReconnectNode(RandomListNode pHead){
        RandomListNode OriginalHead = pHead;
        RandomListNode CopyHead = OriginalHead.next;
        while (OriginalHead != null){
            RandomListNode CloneNode = OriginalHead.next;
            OriginalHead.next = CloneNode.next;
            if(CloneNode.next == null){
                CloneNode.next = null;
            }
            else
            CloneNode.next = OriginalHead.next.next;

            OriginalHead = OriginalHead.next;

        }
        return  CopyHead;
    }

    public static void main(String[] args){
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.random = node3;
        node2.random = node4;
        node3.random = null;
        node4.random = null;

        P187_CopyComplexList test = new P187_CopyComplexList();
        RandomListNode TestNode = test.Clone(node1);

        while (node1 != null) {
            System.out.print(node1.label + " ");
            node1 = node1.next;
        }

    }


}
