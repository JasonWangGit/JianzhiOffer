package Question55;

// https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/

public class Part2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(isBalanced(root));
	}
	
	public static boolean isBalanced(TreeNode root) {
		return func(root) != -1;
	}
	
	public static int func(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftDepth = func(root.left);
        if(leftDepth == -1) {
            return -1;
        }
		int rightDepth = func(root.right);
        if(rightDepth == -1) {
            return -1;
        }
		return Math.abs(leftDepth - rightDepth) <= 1 ? Math.max(leftDepth, rightDepth) + 1 : -1;
	}
}
