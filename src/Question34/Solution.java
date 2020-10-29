package Question34;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/

public class Solution {
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
		if(root == null)
			return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		recur(root, deque, result, sum, 0);
		return result;
    }
	
	public static void recur(TreeNode root, Deque<Integer> deque, List<List<Integer>> result, 
			int targerVal, int currentVal) {
		deque.push(root.val);
		currentVal += deque.peek();
		if(currentVal == targerVal && root.left == null && root.right == null) {
			Iterator<Integer> iterator = deque.descendingIterator();
			ArrayList<Integer> arrayList = new ArrayList<>();
			while(iterator.hasNext())
				arrayList.add(iterator.next());
			result.add(arrayList);
		}
		if(root.left != null)
			recur(root.left, deque, result, targerVal, currentVal);
		if(root.right != null)
			recur(root.right, deque, result, targerVal, currentVal);
		currentVal -= deque.peek();
		deque.pop();
	}
}
