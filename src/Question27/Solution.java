package Question27;

// https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		mirrorTree(root);
	}
	
	public static TreeNode mirrorTree(TreeNode root) {
		if(root != null) {
			if(root.left != null || root.right != null) {
				TreeNode temp = root.left;
				root.left = root.right;
				root.right = temp;
			}
			if(root.left != null) {
				mirrorTree(root.left);
			}
			if(root.right != null) {
				mirrorTree(root.right);
			}
		}
		return root;
    }
}
