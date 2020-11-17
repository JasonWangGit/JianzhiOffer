package Question31;

import java.util.Stack;

// https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/

public class Solution_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		int[] pushed = {1, 0};
		int[] popped = {1, 0};
		System.out.println(validateStackSequences(pushed, popped));
	}
	
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
	    if(pushed == null && popped == null) return true;
	    if(pushed == null || popped == null) return false;
	    if(pushed.length == 0 && popped.length == 0) return true;
	    if(pushed.length == 0 || popped.length == 0 || pushed.length != popped.length) return false;
	    int indexPush = 0;
	    int indexPop = 0;
	    stack.push(pushed[indexPush++]);
	    while(true) {
	        while((stack.isEmpty() || stack.peek() != popped[indexPop]) && indexPush < pushed.length) {
	            stack.push(pushed[indexPush++]);
	        }
	        if(stack.peek() == popped[indexPop]) {
	            stack.pop();
	            indexPop++;
	            if(indexPop == popped.length) return true;
	        } else {
	            if(indexPush == pushed.length) return false;
	        }
	    }
    }
}
