public class Test {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = (n-1) & n;
        }
        return count;
    }
    public static void main(String[] args){
        int n  = 5;
        Test a = new Test();
        int b = a.NumberOf1(n);
        System.out.println(b);

    }
}


