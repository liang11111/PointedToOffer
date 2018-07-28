import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str=input.next();
        int index=FirstNotRepeatingChar(str);
        System.out.println(index);
    }

    public static int FirstNotRepeatingChar(String str) {
        int[] hash =new int[123];
        int len=str.length();
        for(int i=0;i<len;i++){
            char temp=str.charAt(i);
            hash[temp]++;
        }
        int i;
        for(i=0;i<len;i++){
            char temp=str.charAt(i);
            if(hash[temp]==1)
                return i;
        }
        return -1;
    }
}
