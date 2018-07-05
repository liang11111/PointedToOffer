package stackAndQueue;

import java.util.Stack;

public class P165_StackForMin {
    Stack<Integer> data_stack=new Stack<Integer>();//存放所有的数据
    Stack<Integer> min_stack=new Stack<Integer>();//存放每次比较最小的数据
    public void push(int node) {
        data_stack.push(node);//data_stack是存放所有的数据的，所以有数据就要进栈
        if(min_stack.empty()||node<min_stack.peek()){//如果min_stack为空或者node的值小于min_stack的栈顶元素，则直接进栈
            min_stack.push(node);
        }else{
            min_stack.push(min_stack.peek());
        }
    }

    public void pop() {
        data_stack.pop();
        min_stack.pop();
    }

    public int top() {
        if(min_stack.empty()){
            return 0;
        }
        return min_stack.peek();
    }

    public int min() {
        if(min_stack.empty()){
            return 0;
        }
        return min_stack.peek();
    }

    public static void main(String[] args) {
        P165_StackForMin stackForMin = new P165_StackForMin();
        stackForMin.push(3);
        stackForMin.push(4);
        stackForMin.push(2);
        stackForMin.push(1);
        //压入3 4 2 1  辅助栈 3 3 2 1   显示 1 2 3 3
        System.out.println(stackForMin.min());
        stackForMin.pop();
        System.out.println(stackForMin.min());
        stackForMin.pop();
        System.out.println(stackForMin.min());
        stackForMin.pop();
        System.out.println(stackForMin.min());
        //关键是辅助栈  min只负责显示最小值， pop弹出的时候需要把辅助栈也弹出
    }
}
