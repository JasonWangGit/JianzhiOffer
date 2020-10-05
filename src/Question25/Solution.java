package Question25;

// https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/

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
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		display(mergeTwoLists(l1, l2));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 != null) {
			return l2;
		}
		if(l1 != null && l2 == null) {
			return l1;
		}
		if(l1 == null && l2 == null) {
			return null;
		}
		
		ListNode head;
		ListNode l1New;
		ListNode l2New;
		if(l1.val < l2.val) {
			head = l1;
			l1New = l1.next;
			l2New = l2;
		} else {
			head = l2;
			l1New = l1;
			l2New = l2.next;
		}
		
		head.next = mergeTwoLists(l1New, l2New);
		
		return head;
	}
}
