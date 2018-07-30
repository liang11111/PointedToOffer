package arrays;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */

public class P275_FindNumsAppearOnce {
    public void  FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {


        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        //按位与，结果是数组中只出现一次的两个数相与的结果
        int bitResult = 0;
        for (int i = 0; i < array.length; i++) {
            bitResult ^= array[i];
        }

        //找到bitResult中第一个1出现的那位
        int index1 = FindFistNumber1(bitResult);


        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i],index1)) {
                num1[0] ^= array[i];
            }
            else
                num2[0] ^= array[i];
        }

        System.out.println(num1[0] + " " + num2[0]);

    }

    private int FindFistNumber1(int nubmer){
        if (nubmer == 0) {
            return 0;
        }
        int index = 0;
        while (((nubmer & 1) == 0) && index < 32) {
            nubmer = nubmer >> 1;  //number向右移动一位，并将结果赋给原值
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];

        P275_FindNumsAppearOnce test = new P275_FindNumsAppearOnce();
        test.FindNumsAppearOnce(array,num1,num2);
    }

}
