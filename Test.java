
import java.util.Stack;
public class Test {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }

        CloneNodes(pHead);
        CloneRandom(pHead);
        return EvenNode(pHead);
    }

    //根据原始链表的每个结点N创建对应的N',把N'连接在N的后面
    void  CloneNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while(pNode != null){
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pCloned.random = null;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    //设置复制出来的节点的random。假设原始链表上的N的random指向节点S，
    // 那么对应复制出来的N'是N的next指向的节点，同样S'也是S的next指向的节点
    void CloneRandom(RandomListNode pHead){
        
    }

    public RandomListNode EvenNode(RandomListNode phead){
        return  phead;
    }

    public static void main(String[] args) {
        Test stackForMin = new Test();

    }
}


