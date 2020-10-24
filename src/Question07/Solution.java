package Question07;

// https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
		TreeNode root = buildTree(preorder, inorder);
		System.out.println(root);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length)
			return null;
		return recur(preorder, inorder, 
				0, preorder.length - 1, 0, inorder.length - 1);
	}
	
	public static TreeNode recur(int[] preorder, int[] inorder, 
			int preLeft, int preRight, int inLeft, int inRight) {
		TreeNode root = new TreeNode(preorder[preLeft]);
		System.out.println("---------------------------------------");
		System.out.println("root is " + root.val);
		System.out.println("preLeft:" + preLeft);
		System.out.println("preRight:" + preRight);
		System.out.println("inLeft:" + inLeft);
		System.out.println("inRight:" + inRight);
		int rootPos = 0;
		for(int i = inLeft; i <= inRight; i++)
			if(inorder[i] == preorder[preLeft]) {
				rootPos = i;
				break;
			}
		int leftLength = rootPos - inLeft;
		if(rootPos == inLeft)
			root.left = null;
		else
			root.left  = recur(preorder, inorder, preLeft + 1, preLeft + leftLength, inLeft, rootPos - 1);
		if(rootPos == inRight)
			root.right = null;
		else
 			root.right = recur(preorder, inorder, preLeft + leftLength + 1, preRight, rootPos + 1, inRight);
		return root;
	}
}
