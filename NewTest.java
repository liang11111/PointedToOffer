import java.util.Stack;



public class NewTest {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null){
            return null;
        }
        //复制结点
        RandomListNode p = pHead;
        while (p != null){
            RandomListNode q = new RandomListNode(p.label);
            q.next = p.next;
            p.next = q;
            p = q.next;
        }

        //复制random结点
        RandomListNode m = pHead;
        while (m != null){
            if(m.random == null){
                m.next.random = null;
            }
            else
                m.next.random = m.random.next;
            m = m.next.next;
        }

        //取出偶数位置的表
        RandomListNode pCloneHead=pHead.next;
        RandomListNode currentNode;
        currentNode=pHead;
        while(currentNode.next!=null)
        {
            RandomListNode temp=currentNode.next;
            currentNode.next=temp.next;
            currentNode=temp;
        }
        return pCloneHead;
    }






    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        Test a = new Test();
//        boolean b = a.IsPopOrder(pushA,popA);
//        System.out.println(b);
    }
}

