package Question22;

// https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/

public class Solution_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(getKthFromEnd(head, 2).val);
		System.out.println(getKthFromEnd(head, 9));
	}

	public static ListNode getKthFromEnd(ListNode head, int k) {
		if(head == null)
			return null;
		if(k <= 0)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		int index = 1;
		while(fast.next != null) {
			fast = fast.next;
			index++;
			if(index > k)
				slow = slow.next;
		}
		if(index < k)
			return null;
		return slow;
    }
}
