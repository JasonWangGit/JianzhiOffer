package Question32;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/

public class Part3 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		for(List<Integer> list : levelOrder(root)) {
			for(int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		Stack<TreeNode> stackOdd = new Stack<>();
		Stack<TreeNode> stackEven = new Stack<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		boolean levelFlag = true;
		stackOdd.push(root);
		
		while(!stackOdd.isEmpty() || !stackEven.isEmpty()) {
			TreeNode temp;
			if(levelFlag)
				temp = stackOdd.pop();
			else
				temp = stackEven.pop();
			arrayList.add(temp.val);
			if(levelFlag) {
				if(temp.left != null)
					stackEven.push(temp.left);
				if(temp.right != null)
					stackEven.push(temp.right);
			} else {
				if(temp.right != null)
					stackOdd.push(temp.right);
				if(temp.left != null)
					stackOdd.push(temp.left);
			}
			if(stackOdd.isEmpty() && levelFlag) {
				levelFlag = false;
				addToResult(result, arrayList);
			} else if(stackEven.isEmpty() && !levelFlag) {
				levelFlag = true;
				addToResult(result, arrayList);
			}
		}
		return result;
    }
	
	public static void addToResult(List<List<Integer>> result, List<Integer> arrayList) {
		ArrayList<Integer> tempArrayList = new ArrayList<>();
		for(int i : arrayList)
			tempArrayList.add(i);
		result.add(tempArrayList);
		arrayList.clear();
	}
}
