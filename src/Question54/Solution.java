package Question54;

// https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/

public class Solution {
	private static int kVal;
	private static int result;
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		System.out.println(kthLargest(root, 3));
	}
	
	public static int kthLargest(TreeNode root, int k) {
		kVal = k;
		infixOrder(root);
		return result;
    }
	
	public static void infixOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		infixOrder(root.right);
		if(kVal == 0) {
			return;
		}
		if(kVal - 1 == 0)
		{
			result = root.val;
		}
		kVal--;
		infixOrder(root.left);
	}
}
