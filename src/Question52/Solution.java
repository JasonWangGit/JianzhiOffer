package Question52;

// https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/

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
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(2);
		headA.next.next = new ListNode(3);
		headA.next.next.next = new ListNode(6);
		headA.next.next.next.next = new ListNode(7);
		ListNode headB = new ListNode(4);
		headB.next = new ListNode(5);
		headB.next.next = headA.next.next.next;
		display(headA);
		display(headB);
		display(getIntersectionNode(headB, headA));
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) {
			return null;
		}
		int countA = 0;
		int countB = 0;
		ListNode currentA = headA;
		while(currentA != null) {
			currentA = currentA.next;
			countA++;
		}
		ListNode currentB = headB;
		while(currentB != null) {
			currentB = currentB.next;
			countB++;
		}
		int count = Math.abs(countA - countB);
		if(countA > countB) {
			currentA = headA;
			currentB = headB;
			for(int i = 0; i < countA; i++) {
				if(currentA == currentB) {
					break;
				}
				currentA = currentA.next;
				if(i > count - 1) {
					currentB = currentB.next;
				}
			}
		} else {
			currentA = headA;
			currentB = headB;
			for(int i = 0; i < countB; i++) {
				if(currentB == currentA) {
					break;
				}
				currentB = currentB.next;
				if(i > count - 1) {
					currentA = currentA.next;
				}
			}
		}
		return currentA;
    }
}
