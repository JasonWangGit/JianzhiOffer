package Question23;

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = head.next.next;
		System.out.println(findRingEntry(head).val);
	}
	
	public static ListNode findRingEntry(ListNode head) {
		int n = hasRing(head);
		if(n == 0)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		int index = 0;
		while(true) {
			fast = fast.next;
			index++;
			if(index > n)
				slow = slow.next;
			if(slow == fast)
				return slow;
		}
	}
	
	public static int hasRing(ListNode head) {
		if(head == null)
			return 0;
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				ListNode temp = slow;
				int number = 0;
				while(true) {
					slow = slow.next;
					number++;
					if(slow == temp)
						break;
				}
				return number;
			}
		}
		return 0;
	}
}
