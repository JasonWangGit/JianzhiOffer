package Question36;

// https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right = new Node(5);
		// root.right.left = new Node(12);
		// root.right.right = new Node(16);
		
		Node result = treeToDoublyList(root);
		System.out.println(result);
	}
	
	public static Node treeToDoublyList(Node root) {
		if(root == null)
			return null;
		recur(root, null);
		Node first = root;
		while(first.left != null)
			first = first.left;
		Node last = root;
		while(last.right != null)
			last = last.right;
		first.left = last;
		last.right = first;
        return first;
    }
	
	public static Node recur(Node root, Node last) {
		if(root.left != null)
			last = recur(root.left, last);
		root.left = last;
		if(last != null)
			last.right = root;
		last = root;
		if(root.right != null)
			last = recur(root.right, last);
		return last;
	}
}
