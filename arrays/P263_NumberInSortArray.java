package arrays;

public class P263_NumberInSortArray {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {

            return 0;
        }

        int start = 0;
        int end = array.length - 1;
        int fistIndex = GetFirstIndex(array, start, end, k);
        int lastIndex = GetLastIndex(array,start,end,k);

        int result = 0;
        if (fistIndex > -1 && lastIndex > -1) {
             result = lastIndex - fistIndex + 1;
        }
        return result;
    }

    private int GetFirstIndex(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midData = array[midIndex];

        if (midData == k) {
            if (midIndex > 0 && array[midIndex - 1] != k || midIndex == 0) {  // midIndex>0 || midIndex=0

                return midIndex;
            } else {
                end = midIndex - 1;
            }
        }
        else if (midData > k) {
            end = midIndex - 1;
        } else if (midData < k) {
            start = midIndex + 1;
        }
        return GetFirstIndex(array, start, end, k);
    }

    private int GetLastIndex(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midData = array[midIndex];
        if(midData==k){
            if (midIndex < array.length - 1 && array[midIndex + 1] != k || midIndex == array.length - 1) {//注意数组别越界
                return midIndex;
            } else {
                start = midIndex + 1;
            }
        } else if (midData > k) {
            end = midIndex - 1;
        } else if (midData < k) {
            start = midIndex + 1;
        }
        return GetLastIndex(array, start, end, k);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3, 3, 3, 3};
        int k = 3;
        P263_NumberInSortArray test = new P263_NumberInSortArray();
        int result = test.GetNumberOfK(array, k);
        System.out.println(result);
    }
}
