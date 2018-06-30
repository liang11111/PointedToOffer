public class Test {
    public double Power(double base, int exponent) {
        boolean g_InvalidInput = false;
        if(base == 0.0 && exponent < 0){
            g_InvalidInput = true;
            return 0.0;
        }
        int absExponent = exponent;
//        double result = 0.0;
        if(exponent < 0){
            absExponent = -exponent;
        }
        double result = PowerWithUnsigned(base,absExponent);
        if(exponent < 0){
            result = 1.0/result;
        }
        return result;
    }
    public double PowerWithUnsigned(double base,int exponent){
        double result = 1.0;
        for (int i = 1;i <= exponent;i++){
            result *= base;
        }
        return result;
    }
    public  static void main(String[] args){
        double a = 2.0;
        int b = -3;
        Test c = new Test();
        double m = c.Power(a,b);
        System.out.println(m);

    }
}


