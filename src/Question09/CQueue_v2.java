package Question09;

import java.util.Stack;

public class CQueue_v2 {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public CQueue_v2() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
    }
    
    public void appendTail(int value) {
    	stack1.push(value);
    }
    
    public int deleteHead() {
    	if(stack2.isEmpty())
    		if(stack1.isEmpty())
    			return -1;
    		else
				while(!stack1.isEmpty())
					stack2.push(stack1.pop());
    	return stack2.pop();
    }
}
