package arrays;

public class P227_MinNumber{
    public String PrintMinNumber(int [] numbers){
        for(int i=0;i<numbers.length;i++){
            for(int j=numbers.length-1;j>i;j--){
                if(compare(numbers[j-1],numbers[j])>0){
                    int temp=numbers[j-1];
                    numbers[j-1]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
            String ans="";
        for(int i=0;i<numbers.length;i++){
            ans+=numbers[i];
        }

        return ans;
}
    public int compare(int int1,int int2){
        String str1=int1+""+int2;
        String str2=int2+""+int1;
        return str1.compareTo(str2);
    }

    public static void main(String[] args) {
        int[] array = {12, 35, 56, 78, 96, 45, 1, 2};
        P227_MinNumber test = new P227_MinNumber();
        String s = test.PrintMinNumber(array);
        System.out.println(s);
    }
}

