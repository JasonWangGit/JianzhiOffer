package Question23;

public class Solution_v2 {
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
	    ListNode fast = head;
	    ListNode slow = head;
	    int index = 0;
	    int k = hasRing(head);
	    if(k == 0) return null;
	    else {
	        while(true) {
	            fast = fast.next;
	            if(index > k - 1) slow = slow.next;
	            index++;
	            if(fast == slow) return fast;
	        }
	    }
	}

	public static int hasRing(ListNode head) {
	    ListNode fast = head;
	    ListNode slow = head;
	    boolean ringFlag = false;
	    int count = 0;
	    ListNode temp = null;
	    while(fast != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	        if(fast == slow && !ringFlag) {
	            temp = slow;
	            ringFlag = true;
	        }
	        if(ringFlag) {
	            if(slow == temp && count != 0) break;
	            count++;
	        }
	    }
	    return count;
	}
}
