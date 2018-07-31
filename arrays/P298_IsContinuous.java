package arrays;

import java.util.Arrays;

public class P298_IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        Arrays.sort(numbers);
        int NumberZero = 0;
        int NumberGap = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                NumberZero++;
            }
        }

        int small = NumberZero;
        int big = small + 1;

        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            NumberGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }

        return NumberGap > NumberZero ? false : true;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 5, 4};

        P298_IsContinuous test = new P298_IsContinuous();
        boolean result = test.isContinuous(numbers);
        System.out.println(result);
    }
}
