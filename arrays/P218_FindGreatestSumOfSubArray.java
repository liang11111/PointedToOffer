package arrays;

public class P218_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {

        //判断array是否有值
        if (array == null || array.length == 0) {
            return 0;
        }
        //
        int MaxSum = array[0];            //存储连续子元素和的最大值
        int sum = array[0];               // 存储当前连续n项的和
        for (int i = 1; i < array.length; i++) {
            if(sum < 0){
                sum = array[i];     // 如过当前连续n项的和小于等于0,则没必要与后面的元素相加.sum重新赋值
            }
            else {
                sum += array[i];    //如果sum的值大于0,则继续与后面的元素相加
            }

            if(sum > MaxSum){      //每次改变sum的值都有与max进行比较
                MaxSum = sum;      //如果sum的值大于MaxSum,则将sum的值赋值给MaxSum
            }
        }
        //返回最大子数组和
        return MaxSum;
    }

    public static void main(String[] args) {
        int[] array ={-2,-8,-1,-5,-9};
        P218_FindGreatestSumOfSubArray test = new P218_FindGreatestSumOfSubArray();
        int sum = test.FindGreatestSumOfSubArray(array);
        System.out.println(sum);
    }
}
