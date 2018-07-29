package arrays;

import java.util.ArrayList;



// 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
// 如果有多对数字的和等于S，输出两个数的乘积最小的

public class P280_SumSOfTwoNumber {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i =0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else if (array[i] + array[j] < sum) {
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        P280_SumSOfTwoNumber test = new P280_SumSOfTwoNumber();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 52, 89, 100};
        int sum = 19;
        list = test.FindNumbersWithSum(array,sum);
        System.out.println(list);
    }
}
