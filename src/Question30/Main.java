package Question30;

import java.util.Stack;

//https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/

public class Main {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-1);
		System.out.println(minStack.min());
		System.out.println(minStack.top());
		minStack.pop();
		System.out.println(minStack.min());
	}
}
