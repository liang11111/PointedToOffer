package arrays;



public class P243_FirstNotRepeatingChar {
        public int FirstNotRepeatingChar(String str) {
            int[] hash = new int[123];
            for(int i =0;i<str.length();i++){
                char temp = str.charAt(i);
                hash[temp]++;
            }

            for (int i = 0; i < str.length(); i++) {
                char temp =str.charAt(i);
                if (hash[temp] == 1) {
                    return i;
                }
            }
            return -1;
        }


    public static void main(String[] args) {
        String str = "abcjnduadbndlnsuebaljsnfuendlhdawubsoa";
        P243_FirstNotRepeatingChar test = new P243_FirstNotRepeatingChar();
        int result = test.FirstNotRepeatingChar(str);
        System.out.println(result);
    }
}
