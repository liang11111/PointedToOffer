package Number;

public class P_110 {
    public double Power(double base, int exponent) {
        boolean g_InvalidInput = false;
        if (base ==0.0 && exponent < 0) {
            g_InvalidInput = true;
            return 0.0;
        }
        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }
        double result = PowerWithUnsignedExponent(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }
    public double PowerWithUnsignedExponent(double base,int absExponent){
        double result = 1.0;
        for (int i = 1;i <= absExponent;i++){
        result*= base;
        }
        return result;
        }
    public  static void main(String[] args){
        double a = 2.0;
        int m = -3 ;
        P_110 k = new P_110();
        double n = k.Power(a,m);
        System.out.println(n);
    }

}
