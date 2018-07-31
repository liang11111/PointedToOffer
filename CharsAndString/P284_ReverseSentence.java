package CharsAndString;

public class P284_ReverseSentence {


    public static void main(String[] args) {
        String str = "I am a student";

        P284_ReverseSentence test = new P284_ReverseSentence();
        String result = test.ReverseSentence(str);
        System.out.println(result);
    }

    public String ReverseSentence(String str) {
        if( str == null ){
            return null;
        }

        char[] CharArray = str.toCharArray();

        //翻转整个句子
        P286_LeftRotateString reverseAll = new P286_LeftRotateString();
        int start = 0;
        int end = CharArray.length - 1;
        reverseAll.Reverse(CharArray,start,end);

        // 反转句子的每个单词
        for (int i = 0; i < CharArray.length; i++) {

            int low = i;
            int hight = i;
            while (i < CharArray.length && CharArray[i] != ' ') {
                i++;
            }

            hight = i - 1;
            P286_LeftRotateString reverseWord = new P286_LeftRotateString();
            reverseWord.Reverse(CharArray,low,hight);
        }
        return String.valueOf(CharArray);
    }
}
