package Question30;

import java.util.Stack;

class MinStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
    /** initialize your data structure here. */
    public MinStack() {
    	stack = new Stack<>();
    	minStack = new Stack<>();
    }
    
    public void push(int x) {
    	if(stack.isEmpty()) {
    		stack.push(x);
    		minStack.push(x);
    	} else {
    		stack.push(x);
    		if(x < minStack.peek())
    			minStack.push(x);
    		else
    			minStack.push(minStack.peek());
    	}
    	
    }
    
    public void pop() {
    	if(stack.isEmpty())
    		return;
    	stack.pop();
    	minStack.pop();
    }
    
    public int top() {
    	if(stack.isEmpty())
    		return -1;
    	return stack.peek();
    }
    
    public int min() {
    	if(stack.isEmpty())
    		return -1;
    	return minStack.peek();
    }
}