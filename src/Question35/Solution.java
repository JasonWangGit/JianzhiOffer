package Question35;

// https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/

public class Solution {
	public static void display(Node listNode) {
		if(listNode == null) {
			return;
		}
		Node current = listNode;
		while(current.next != null) {
			System.out.print(current.val + "->");
			current = current.next;
		}
		System.out.println(current.val);
	}
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.random = head.next.next;
		head.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next;
		
		copyRandomList(head);
	}
	
	public static Node copyRandomList(Node head) {
		if(head == null)
			return null;
		copyAndMerge(head);
		addRandom(head);
        return split(head);
    }
	
	public static void copyAndMerge(Node head) {
		Node current = head;
		while(current != null) {
			Node nodeCopy = new Node(current.val);
			nodeCopy.next = current.next;
			nodeCopy.random = null;
			current.next = nodeCopy;
			current = nodeCopy.next;
		}
	}
	
	public static void addRandom(Node head) {
		Node current = head;
		while(current != null) {
			Node next = current.next;
			if(current.random != null)
				next.random = current.random.next;
			current = next.next;
		}
	}
	
	public static Node split(Node head) {
		Node current = head;
		Node headCopy = current.next;
		Node currentCopy = headCopy;
		current.next = currentCopy.next;
		current = current.next;
		while(current != null) {
			currentCopy.next = current.next;
			currentCopy = currentCopy.next;
			current.next = currentCopy.next;
			current = current.next;
		}
		return headCopy;
	}
}
