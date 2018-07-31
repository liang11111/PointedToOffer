package CharsAndString;

public class P286_LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() < 2 || str.length() < n) {
            return str;
        }

        char[] CharArray = str.toCharArray();
        Reverse(CharArray, 0, n - 1);
        Reverse(CharArray, n, CharArray.length-1);
        Reverse(CharArray, 0,CharArray.length-1);

        //String result = CharArray.toString();
        //return result;

        return String.valueOf(CharArray);
    }


    public void Reverse(char[] CharArray, int start, int end) {
        char temp = ' ';
        while (start < end) {
            temp = CharArray[start];
            CharArray[start++] = CharArray[end];
            CharArray[end--] = temp;
        }
    }
    public static void main(String[] args) {
        String str = "abcXYZdef";
        P286_LeftRotateString test = new P286_LeftRotateString();
        int n = 3;
        String result = test.LeftRotateString(str, n);
        System.out.println(result);
    }
}
