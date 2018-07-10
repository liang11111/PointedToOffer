public class Solution {

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    //复制的时候这个RandomListNode不要复制过去，不然会报一堆错。因为它那个平台本身就有这个类了 。以后肯定也会有类似这样的问题，要记住这个
    //只要下面这些就可以了
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        //创建复制后的链表
        cloneNodes(pHead);
        //连接复制节点的兄弟节点
        connectSibling(pHead);
        //将原始节点和复制节点分开
        return reconnectNodes(pHead);
    }

    //复制节点
    public void cloneNodes(RandomListNode head){
        RandomListNode nowNode = head;
        while(nowNode != null){
            RandomListNode clonedNode = new RandomListNode(nowNode.label);
            clonedNode.next = nowNode.next;
            nowNode.next = clonedNode;

            nowNode = clonedNode.next;
        }
    }

    //连接复制节点的兄弟节点
    public void connectSibling(RandomListNode head){
        RandomListNode nowNode = head;
        while(nowNode != null){
            RandomListNode cloned = nowNode.next;
            if(nowNode.random != null){
                cloned.random = nowNode.random.next;
            }
            nowNode =  cloned.next;
        }
    }

    //将原始节点和复制节点分开
    public RandomListNode reconnectNodes(RandomListNode head){
        RandomListNode clonedHead = head.next;
        RandomListNode nowNode = head;
        while(nowNode != null){
            RandomListNode clonedNode = nowNode.next;

            nowNode.next = clonedNode.next;
            clonedNode.next = clonedNode.next == null ? null : clonedNode.next.next;
            nowNode = nowNode.next;
        }
        return clonedHead;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(2);
        RandomListNode node2 = new RandomListNode(3);
        head.next = node1;
        node1.next = node2;
        head.random = node2;
        node1.random = node2;
        node2.random = head;

        //跟上次一样的道理，在主函数中新建一个用来测试的类
        Solution solutionTest = new Solution();
        RandomListNode cloneHead = solutionTest.Clone(head);

        while(cloneHead != null){
            if(cloneHead.random != null){
                System.out.println(cloneHead.random.label);
            }else{
                System.out.println("-");
            }
            cloneHead = cloneHead.next;
        }

    }
}


