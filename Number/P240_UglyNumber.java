package Number;

public class P240_UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] UglyArray = new int[index];
        UglyArray[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for (int i = 1; i < index; i++) {
            int min = min(UglyArray[multiply2] * 2, UglyArray[multiply3] * 3, UglyArray[multiply5] * 5);
            UglyArray[i] = min;
            while (UglyArray[multiply2] * 2 == min) {
                multiply2++;
            }
            while (UglyArray[multiply3] * 3 == min) {
                multiply3++;
            }
            while (UglyArray[multiply5] * 5 == min) {
                multiply5++;
            }
        }
        return UglyArray[index - 1];
    }

    public int min(int number1, int number2, int number3) {
        int min = number1 < number2 ? number1 : number2;
        return min < number3 ? min : number3;
    }

    public static void main(String[] args) {
        int number=1;
        P240_UglyNumber test = new P240_UglyNumber();
        int result = test.GetUglyNumber_Solution(number);
        System.out.println(result);
    }
}
