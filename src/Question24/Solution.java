package Question24;

// https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/

public class Solution {
	public static void display(ListNode listNode) {
		if (listNode == null) {
			return;
		}
		ListNode current = listNode;
		while (current.next != null) {
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
		display(reverseList(head));
	}
	
	public static ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		
		if(head.next == null) {
			return head;
		}
		
		ListNode previous = null;
		ListNode current = head;
		ListNode after = head.next;
		
		while(after != null) {
			previous = current;
			current = after;
			after = after.next;
			current.next = previous;
			if(previous == head) {
				previous.next = null;
			}
		}
		
		return current;
    }
}
