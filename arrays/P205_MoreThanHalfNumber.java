package arrays;

public class P205_MoreThanHalfNumber {
    //初始时，number指向数组中的第一个元素，count的值为1。
    // 开始遍历，若count的值为0，将number置为当前数组的值，进行下一个位置的遍历；
    // 若当前位置的值和number相等，cur++；否则cur--。
    // 直到遍历到数组的最后一个位置。
    // 最后我们要进行验证，因为数组中可能不存在出现次数超过一半的数字。
    // 验证的方式也很简单，遍历数组，判断数组中的数和num的值相等的个数是否超过数组长度的一半，若超过则该数为number；
    // 否则数组中不存在出现次数超过一半的数字，返回0。

    private int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int count = 1;
        int number = array[0];
        for (int i = 1; i < array.length; i++) {
            if(count == 0){
                number = array[i];
                count++;
            }
            if(array[i] == number){
                count++;
            }
            else count--;
        }
        int time = 0;
        for (int j = 0; j < array.length; j++) {

            if(array[j] == number){
                time++;
            }
        }
        if(time > array.length/2){
            return number;
        }
        else return 0;
    }



    public static void main(String[] args) {
        int[] array = {1,2,3,2,4,2,5,2,3};
        P205_MoreThanHalfNumber test = new P205_MoreThanHalfNumber();
        int m = test.MoreThanHalfNum_Solution(array);
        System.out.println(m);
    }
}
