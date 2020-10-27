package Question28;

// https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/

public class Solution {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(5);
		System.out.println(isSymmetric(root));
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return isSymmetric(root.left, root.right);
    }
	
	public static boolean isSymmetric(TreeNode A, TreeNode B) {
		if(A == null && B == null)
			return true;
		if(A == null || B == null)
			return false;
		if(A.val == B.val)
			return isSymmetric(A.left, B.right) && isSymmetric(A.right, B.left);
		else
			return false;
    }
}
