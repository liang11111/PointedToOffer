package Number;

import java.util.ArrayList;

public class P282_FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listall = new ArrayList<ArrayList<Integer>>();
        if(sum < 3)
        {
            return listall; //因为至少要包括两个数，要求的是正整数序列，那么最小的和为3
        }
        int small = 1;//用来记录正整数序列中最小的数，
        int big = 2;//用来记录正整数序列中最大的数
        int mid = (sum + 1)/2;//序列之和为sum的数至少包括两个数，所以small<mid
        int cursum = small + big;//当前序列总和
        while(small < mid)
        {
            //当前的序列和大于sum
            while(cursum > sum && small < mid)
            {
                cursum = cursum-small;
                small++;
            }
            //当前序列和为sum了，则将这些数加入到list中
            if(cursum == sum)
            {
                ArrayList<Integer> listsum = new ArrayList<Integer>();
                add(listsum,small,big);
                listall.add(listsum);

            }
            //当前的序列和小于sum
            big++;
            cursum = cursum+big;

        }
        return listall;
    }
    private static void add(ArrayList<Integer> list,int small,int big)
    {
        for (int i = small; i <= big; i++)
        {
            list.add(i);
        }
    }
}
