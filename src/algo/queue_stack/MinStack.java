package algo.queue_stack;

import java.util.Random;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public int getMin(){
        if (minStack == null)
            return Integer.MIN_VALUE;

        stack.pop();
        return minStack.pop();
    }
    public void push(int val){
        if (stack.isEmpty()){
            stack.push(val);
            minStack.push(val);
        }
        if (stack.peek() < val)
            minStack.push(minStack.peek());
        else
            minStack.push(val);
        stack.push(val);
    }
}
