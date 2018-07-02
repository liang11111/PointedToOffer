package linkedList;

public class P145_MergeList {
    public ListNode Merge(ListNode list1,ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode megerList = null;
        if(list1.val < list2.val){
            megerList =list1;
            megerList.next = Merge(list1.next,list2);
        }
        else {
            megerList = list2;
            megerList.next = Merge(list1,list2.next);
        }
        return megerList;
    }
    public static void main(String[] args){
        P145_MergeList m = new P145_MergeList();


    }
}
