package Question27;

// https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/

public class Solution_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.left.left = new TreeNode(3);
		treeNode.left.left.left = new TreeNode(4);
		treeNode.left.left.left.left = new TreeNode(5);
		mirrorTree(treeNode);
		treeNode = null;
	}
	
	public static TreeNode mirrorTree(TreeNode root) {
		if(root == null)
			return null;
		if(root.left != null || root.right != null) {
			swap(root);
			if(root.left != null)
				mirrorTree(root.left);
			if(root.right != null)
				mirrorTree(root.right);
		}
		return root;
    }
	
	public static void swap(TreeNode root) {
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
}
