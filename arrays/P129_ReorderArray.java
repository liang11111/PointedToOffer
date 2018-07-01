package arrays;

public class P129_ReorderArray {
    public void reOrderArray(int [] array) {
        int count = 0;
        //数组中奇数的个数
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                count++;
            }
        }
        //奇数和偶数分别存放在一个数组
        int[] evenArray = new int[count];
        int[] oddArray = new int[array.length - count];
        int j = 0;
        int m = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                evenArray[j] = array[i];
                j++;

            }
            else{
                oddArray[m] = array[i];
                m++;
            }
        }
        //将奇数部分 赋值给array前部分
        for(int i = 0;i < oddArray.length;i++){
            array[i] = oddArray[i];
        }
        //将偶数部分赋值给array
        for(int p = 0;p < evenArray.length;p++){
            array[oddArray.length + p] = evenArray[p];
        }

        //打印数组array内容
        for(int n = 0; n < array.length;n++){
            System.out.print(array[n]);
        }
    }
    public static void main(String[] args){
        int[] n  = {2};
        P129_ReorderArray a = new P129_ReorderArray();
        a.reOrderArray(n);
//        System.out.println(b);

    }
}
