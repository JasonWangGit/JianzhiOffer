package Question32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/

public class Part1 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);
		
		for(int i : levelOrder(root))
			System.out.print(i + " ");
	}
	
	public static int[] levelOrder(TreeNode root) {
		if(root == null)
			return new int[0];
		ArrayList<Integer> arrayList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			arrayList.add(temp.val);
			if(temp.left != null)
				queue.offer(temp.left);
			if(temp.right != null)
				queue.offer(temp.right);
		}
		int[] result = new int[arrayList.size()];
		for(int i = 0; i < arrayList.size(); i++)
			result[i] = arrayList.get(i);
		return result;
    }
}
