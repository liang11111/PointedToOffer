package Ask;

public class SolutionNew {

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


    /**复制节点
     * cloneNodes(pHead); //调用下面的clodeNode函数 ，
     * public void cloneNodes(RandomListNode head)
     * pHead传给RandomListNode head（书里面常说的形参），一般不直接对形参进行操作，
     * 而是给形参一个名字，比如nowNode可以形象地代表‘当前节点’
     * 对形参的修改是否会改变原来的 可以看测试类Test
     * @param head
     */
    public void cloneNodes(RandomListNode head){
        RandomListNode nowNode = head;  //nowNode代表当前节点
        while(nowNode != null){
            RandomListNode clonedNode = new RandomListNode(nowNode.label); //第一步复制当前节点
            clonedNode.next = nowNode.next;                                //第二步第三步将复制节点连接到当前节点的后面
            nowNode.next = clonedNode;                                     //并制定复制节点后一节点是当前节点的后一节点
            nowNode = clonedNode.next;
        }
    }

    /**连接复制节点的兄弟节点
     * connectSibling(pHead);
     * pHead传给形参head
     * 此时head为pHead，也为复制之后的链表（包括原链表与复制链表，但缺少兄弟节点，也即random分量
     * 假设当前节点的A的random分量为C ,那么复制节点A' 的random分量就要为C' 而C'为C的next
     * 假设当前节点的B的random分量为D ,那么复制节点B' 的random分量就要为D' 而D'为D的next
     * @param head
     */
    public void connectSibling(RandomListNode head){
        RandomListNode nowNode = head;
        while(nowNode != null){
            RandomListNode cloned = nowNode.next; //第一步跟第三步就是实现链表的遍历
            if(nowNode.random != null){
                cloned.random = nowNode.random.next; // 当前节点的random分量的next赋值给复制节点的random分量
                                                     // 即A的random分量为C ,那么A' 的random分量就要为C' 而C'为C的next
            }
            nowNode =  cloned.next;
        }
    }



    /**
     * 将原始节点和复制节点分开
     * 最后返回复制节点的头部，而这个头部节点有next（指向下一个复制节点）,这样也即返回了复制链表
     * 。
     * @param head
     * @return
     */
    public RandomListNode reconnectNodes(RandomListNode head){
        RandomListNode clonedHead = head.next; //cloneHead为复制节点的头部
        RandomListNode nowNode = head;
        //有了复制节点的头部还不行，还要得到复制链表的链接关系
        while(nowNode != null){
            RandomListNode clonedNode = nowNode.next;
            nowNode.next = clonedNode.next;                                          //制定原始节点的链接关系  即让A->A' 断开，改成A->B
            clonedNode.next = clonedNode.next == null ? null : clonedNode.next.next; //制定复制节点的链接关系  即让A'-B  断开，改成A'->B'
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
        SolutionNew solutionTest = new SolutionNew();
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


