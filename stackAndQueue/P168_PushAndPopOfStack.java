package stackAndQueue;

import java.util.Stack;

public class P168_PushAndPopOfStack {
    public boolean IsPopOrder(int[] pushA, int[] popA){
        if(pushA == null || pushA == null || pushA.length != popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek() == popA[index]){

                stack.pop();
                index++;

            }
        }
        return stack.empty();
    }
    public static void main(String[] args){
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        P168_PushAndPopOfStack a = new P168_PushAndPopOfStack();
        boolean b = a.IsPopOrder(pushA,popA);
        System.out.println(b);
    }
}
