package Question52;

import java.util.Stack;

// https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/

public class Solution_v2 {
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
		ListNode headA = new ListNode(2);
		// headA.next = new ListNode(2);
		// headA.next.next = new ListNode(3);
		// headA.next.next.next = new ListNode(6);
		// headA.next.next.next.next = new ListNode(7);
		ListNode headB = new ListNode(1);
		headB.next = headA;
		// headB.next.next = headA.next.next.next;
		display(headA);
		display(headB);
		// display(getIntersectionNode(headB, headA));
		display(getIntersectionNode(headB, headA));
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int countA = 0, countB = 0;
		ListNode currentA = headA, currentB = headB;
		while(currentA != null) {
			countA++;
			currentA =currentA.next;
		}
		while(currentB != null) {
			countB++;
			currentB = currentB.next;
		}
		if(countA > countB)
			while(countA > countB) {
				countA--;
				headA = headA.next;
			}
		else
			while(countB > countA) {
				countB--;
				headB = headB.next;
			}
		while(countA > 0) {
			if(headA == headB) return headA;
			countA--;
			headA = headA.next;
			headB = headB.next;
		}
		return null;
    }

	public static ListNode getIntersectionNodeByStack(ListNode headA, ListNode headB) {
		Stack<ListNode> stackA = new Stack<>();
		Stack<ListNode> stackB = new Stack<>();
		while(headA != null) {
			stackA.push(headA);
			headA = headA.next;
		}
		while(headB != null) {
			stackB.push(headB);
			headB = headB.next;
		}
		ListNode temp = null;
		boolean isSame = false;
		while(!stackA.isEmpty() && !stackB.isEmpty()) {
			if(stackA.peek() == stackB.peek()) {
				temp = stackA.pop();
				stackB.pop();
				isSame = true;
			} else {
				if(!isSame) return null;
				else break;
			}
		}
		return temp;
    }
}
