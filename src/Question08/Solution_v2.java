package Question08;

public class Solution_v2 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode('a');
		
		root.left = new TreeNode('b');
		root.left.parent = root;
		
		root.left.left = new TreeNode('d');
		root.left.left.parent = root.left;
		
		root.left.right = new TreeNode('e');
		root.left.right.parent = root.left;
		
		root.left.right.left = new TreeNode('h');
		root.left.right.left.parent = root.left.right;
		
		root.left.right.right = new TreeNode('i');
		root.left.right.right.parent = root.left.right;
		
		root.right = new TreeNode('c');
		root.right.parent = root;
		
		root.right.left = new TreeNode('f');
		root.right.left.parent = root.right;
		
		root.right.right = new TreeNode('g');
		root.right.right.parent = root.right;
		
		// if(findNext(root, root.right.right) == null)
		//     System.out.println("null");
		// else
			System.out.println(findNext(root, root).val);
	}
	
	public static TreeNode findNext(TreeNode root, TreeNode treeNode) {
		if(root == null) return null;
	    if(treeNode.right != null) {
	        TreeNode current = treeNode.right;
	        while(current.left != null) current = current.left;
	        return current;
	    } else if(root.parent == null) return null;
	    else if(treeNode == treeNode.parent.left)
	        return treeNode.parent;
	    else {
	        TreeNode current = treeNode.parent;
	        
	        while(current != current.parent.left) {
	            current = current.parent;
	            if(current == root) return null;
	        }
	        return current;
	    }
	}
	
}
