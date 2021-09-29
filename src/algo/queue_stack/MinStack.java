package algo.queue_stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void getMin(){
        if (minStack.isEmpty())
            System.out.println(Integer.MIN_VALUE);
        else
            System.out.println(minStack.pop());

    }
    public void push(int val){
        if (stack.isEmpty() && minStack.isEmpty()){
            stack.push(val);
            minStack.push(val);
        }
        if (stack.peek() < val)
            minStack.push(minStack.peek());
        else
            minStack.push(val);
        stack.push(val);
    }
    public void pop(){
        if (!stack.isEmpty() && !minStack.isEmpty()){
            stack.pop();
            minStack.pop();
            System.out.println("After pop");
            System.out.println(stack.toString());
            System.out.println(minStack.toString());
        }
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(10);
        ms.pop();
        ms.push(3);
        ms.push(8);
        ms.getMin();
        ms.push(1);
        ms.push(7);
        ms.getMin();
        ms.push(5);
        ms.pop();
        ms.pop();
        ms.pop();
        ms.getMin();
    }
}
