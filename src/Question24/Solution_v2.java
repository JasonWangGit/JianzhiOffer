package Question24;

// https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/

public class Solution_v2 {
	public static void display(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode current = head;
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
		if(head == null)
			return null;
		ListNode last = null;
		ListNode current = head;
		ListNode next = head.next;
		while(next != null) {
			current.next = last;
			last = current;
			current = next;
			next = next.next;
		}
		current.next = last;
		return current;
    }
}
