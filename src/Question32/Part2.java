package Question32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/

public class Part2 {
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

		for(List<Integer> list : levelOrder(root)) {
			for(int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
			
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		int currentLevel = 1;
		int nextLevel = 0;
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			arrayList.add(temp.val);
			currentLevel--;
			if(temp.left != null) {
				queue.offer(temp.left);
				nextLevel++;
			}
			if(temp.right != null) {
				queue.offer(temp.right);
				nextLevel++;
			}
			if(currentLevel == 0) {
				currentLevel = nextLevel;
				nextLevel = 0;
				ArrayList<Integer> tempArrayList = new ArrayList<>();
				for(int i : arrayList)
					tempArrayList.add(i);
				result.add(tempArrayList);
				arrayList.clear();
			}
		}
		return result;
    }
}
