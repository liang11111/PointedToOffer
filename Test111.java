public class Test111 {

        //对数的操作
        public void decrease(int a) {
            int c = a;
            c = c - 3;
        }

        public static class Zhizhen {
            int label;
            Zhizhen next = null;
            Zhizhen random = null;
            Zhizhen(int label) {
                this.label = label;
            }
        }

        //类似于对指针的操作
        public void Zhizhencaozuo(Zhizhen a) {
            Zhizhen zhizhenb = a;
            zhizhenb.next = null;
        }

        public static void main(String[] args) {
            int b = 6;
            //主函数新建测试类
            Test111 test = new Test111();
            test.decrease(b);
            System.out.println(b);   //形参对数的操作，不影响原来的数
            Zhizhen zhizhen = new Zhizhen(1);
            Zhizhen zhizhen1 = new Zhizhen(2);
            zhizhen.next = zhizhen1;
            test.Zhizhencaozuo(zhizhen);
            System.out.println(zhizhen.next); //形参对指针的操作，影响原来的
            //虽然java没有指针的‘概念’，但是实际上底层还是使用底层来实现的，只是上层(通过.和类还有调用关系等）屏蔽了底层的操作
            //原来的对象与形参用的是同一个指针，形参对指针的操作，即改变指针指向，显然也改变原来的对象的指针指向
            //所以java中没有 a->b,但是有a.next=b  相当于对指针做了限制，最起码调用方式改了
        }

}
