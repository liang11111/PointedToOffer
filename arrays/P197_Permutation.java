package arrays;


import java.util.ArrayList;
import java.util.TreeSet;

public class P197_Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();

        if (str==null||str.length() == 0) {
            return list;
        }
        char[] chs = str.toCharArray();
        TreeSet<String> treeSet = new TreeSet<>();
        DiGui(chs,0,treeSet);

        list.addAll(treeSet);
        return list;
    }



    private static void DiGui(char[] str, int begin, TreeSet<String> treeSet) {
        if(str == null || str.length == 0 || begin < 0 || begin > str.length-1){
            return ;
        }
        if (begin == str.length - 1) {
            treeSet.add(String.valueOf(str));

        }

        else {
            for (int i = begin; i < str.length; i++) {
                if(i != begin){
                    swap(str,i,begin);
                }
                DiGui(str, begin + 1, treeSet);
                if (i != begin) {
                        swap(str, i, begin);
                }
            }
        }

    }

    private static void swap(char[] str,int i ,int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;

    }

    public static void main(String[] args) {
        String str = "abc";
        P197_Permutation test = new P197_Permutation();
        ArrayList<String> list11 = test.Permutation(str);
      System.out.println(list11);
    }
}
