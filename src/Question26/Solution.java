package Question26;

// https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		TreeNode A = new TreeNode(8);
		A.left = new TreeNode(8);
		A.left.left = new TreeNode(9);
		A.left.right = new TreeNode(2);
		A.left.right.left = new TreeNode(4);
		A.left.right.right = new TreeNode(7);
		A.right = new TreeNode(7);
		
		TreeNode B = new TreeNode(9);
		B.left = new TreeNode(9);
		B.right = new TreeNode(2);
		
		System.out.println(isSubStructure(A, B));
	}
	
	public static boolean isSubStructure(TreeNode A, TreeNode B) {
		if(B == null)
			return false;
		if(A == null)
			return false;
		boolean result = false;
		if(A.val == B.val)
			result = compareTree(A, B);
		if(!result)
			result = isSubStructure(A.left, B);
		if(!result)
			result = isSubStructure(A.right, B);
		return result;
    }
	
	public static boolean compareTree(TreeNode A, TreeNode B) {
		if(B == null)
			return true;
		if(A == null)
			return false;
		if(A.val == B.val)
			return compareTree(A.left, B.left) && compareTree(A.right, B.right);
		else
			return false;
	}
}
