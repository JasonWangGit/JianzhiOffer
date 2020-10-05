package Question06;

import java.util.Stack;

// https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

public class Solution {
	public static void display(ListNode listNode) {
		if(listNode == null) {
			return;
		}
		ListNode current = listNode;
		while(current.next != null) {
			System.out.print(current.val + "->");
			current = current.next;
		}
		System.out.println(current.val);
	}
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		display(head);
	}
	
	public static int[] reversePrint(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		ListNode current = head;
		int i = 0;
		while(current != null) {
			stack.push(current.val);
			current = current.next;
			i++;
		}
		int[] array = new int[i];
		for(int j = 0; j < i; j++) {
			array[j] = stack.pop();
		}
		return array;
    }
}
