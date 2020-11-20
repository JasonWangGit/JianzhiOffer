package Question34;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/

public class Solution_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);
		root.right = new TreeNode(12);
		
		for(List<Integer> list : pathSum(root, 22)) {
			for(int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
	    if(root == null) return new ArrayList<>();
	    List<List<Integer>> result = new ArrayList<>();
	    Deque<Integer> stack = new LinkedList<>();
	    recur(root, result, stack, 0, sum);
	    return result;
	}

	public static void recur(TreeNode root, List<List<Integer>> result, Deque<Integer> stack, int currentSum, int sum) {
		stack.push(root.val);
	    currentSum += root.val;
	    if(root.left == null && root.right == null && currentSum == sum)  addToResult(result, stack);
	    if(currentSum > sum) return;
	    if(root.left != null) recur(root.left, result, stack, currentSum, sum);
	    if(root.right != null) recur(root.right, result, stack, currentSum, sum);
	    stack.pop();
	}

	public static void addToResult(List<List<Integer>> result, Deque<Integer> stack) {
		List<Integer> tempList = new ArrayList<>();
	    Iterator<Integer> iterator = stack.descendingIterator();
	    while(iterator.hasNext())
	         tempList.add(iterator.next());
	    result.add(tempList);
	}
}
