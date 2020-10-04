package Question55;

// https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/

public class Part1 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(maxDepth(root));
	}
	
	public static int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right))  + 1;
	}
}
