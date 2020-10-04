package Question22;

// https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/

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
		display(getKthFromEnd(head, 0));
	}

	public static ListNode getKthFromEnd(ListNode head, int k) {
		if(head == null) {
			return null;
		}
        ListNode pointerFirst = head;
        ListNode pointerSecond = head;
        int index = 0;
        while(pointerFirst != null) {
            pointerFirst = pointerFirst.next;
            index++;
            if(index > k) {
                pointerSecond = pointerSecond.next;
            }
            if(pointerFirst == null) {
                return pointerSecond;
            }
        }
        return pointerFirst;
    }
}
