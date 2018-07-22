package Number;
public class P221_NumberOf1BetweenN {
    public static  int numberOf1BetweenN(int n ){
        if(n < 0){
            return 0;
        }

        String s = n + "";

        return NumberOf1(s);
    }
    public static int NumberOf1(String s){
        char[] number = s.toCharArray();
        int length = number.length;
        if (length == 1 && number[0] == '0') {
            return 0;
        }
        if (length == 1 && number[0] >= '1') {
            return  1;
        }

        int NuberOfFirstDigit = 0;
        if (number[0] > '1') {
            NuberOfFirstDigit = (int)Math.pow(10,length-1);
        }
        if (number[0] == '1') {
            NuberOfFirstDigit = Integer.parseInt(s.substring(1)) + 1;
        }
        int NumberOfOtherDigits = (int) ((number[0] - '0') * (length - 1) * Math.pow(10, length - 2));
        int NumberRecursive = NumberOf1(s.substring(1));
        return NuberOfFirstDigit + NumberOfOtherDigits + NumberRecursive;

    }


    public static void main(String[] args) {
        P221_NumberOf1BetweenN test = new P221_NumberOf1BetweenN();
        int n = 1;
        int Num = test.numberOf1BetweenN(n);
        System.out.println(Num);
    }


}

