package Question25;

import java.awt.List;

// https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/

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
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		display(mergeTwoLists(null, null));
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode listNode = null;
		if(l1.val <= l2.val) {
			listNode = l1;
			listNode.next = mergeTwoLists(l1.next, l2);
		}
		else {
			listNode = l2;
			listNode.next = mergeTwoLists(l1, l2.next);
		}
		return listNode;
	}
}
