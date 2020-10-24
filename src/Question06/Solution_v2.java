package Question06;

import java.util.Stack;

// https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

public class Solution_v2 {
	public static void display(int[] nums) {
		for(int i : nums)
			System.out.print(i + " ");
	}
	
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		display(reversePrintByStack(null));
		System.out.println();
		//reversePrintByRecur(head);
	}
	
	public static int[] reversePrintByStack(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while(head != null) {
			stack.push(head.val);
			i++;
			head = head.next;
		}
		int[] nums = new int[i];
		i = 0;
		while(!stack.isEmpty())
			nums[i++] = stack.pop();
		return nums;
    }
	
	public static void reversePrintByRecur(ListNode head) {
		if(head == null)
			return;
		reversePrintByRecur(head.next);
		System.out.print(head.val + " ");
    }
}
