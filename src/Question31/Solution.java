package Question31;

import java.util.Stack;

// https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		int[] pushed = {1, 2, 3, 4, 5};
		int[] popped = {4, 5, 3, 2, 1};
		System.out.println(validateStackSequences(pushed, popped));
	}
	
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed == null && popped == null)
			return true;
		if(pushed == null || popped == null)
			return false;
		if(pushed.length == 0 && popped.length == 0)
			return true;
		if(pushed.length == 0 || popped.length == 0)
			return false;
		Stack<Integer> stack = new Stack<>();
		int indexPushed = 0;
		int indexPoped = 0;
		while(true) {
			if(stack.isEmpty()) 
				stack.push(pushed[indexPushed++]);
			else
				if(popped[indexPoped] == stack.peek()) {
					popped[indexPoped++] = stack.pop();
					if(indexPoped == popped.length)
						return true;
				}
				else
					if(indexPushed < pushed.length)
						stack.push(pushed[indexPushed++]);
					else
						return false;
		}
    }
}
