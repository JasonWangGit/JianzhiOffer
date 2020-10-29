package Question33;

// https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		// int[] postorder = {5, 7, 6, 9, 11, 10, 8};
		// int[] postorder = {7, 4, 5, 6};
		// int[] postorder = new int[0];
		int[] postorder = {1, 2, 5, 10, 6, 9, 4, 3};
		System.out.println(verifyPostorder(postorder));
	}
	
	public static boolean verifyPostorder(int[] postorder) {
		if(postorder == null)
			return false;
		if(postorder.length == 0)
			return true;
		return recur(postorder, 0, postorder.length - 1);
    }
	
	public static boolean recur(int [] postorder, int start, int end) {
		if(start == end)
			return true;
		int middle = end;
		boolean middleFlag = true;
		for(int i = start; i < end; i++) {
			if(postorder[i] > postorder[end] && middleFlag) {
				middleFlag = false;
				middle = i;
			}
			if(i > middle)
				if(postorder[i] < postorder[end])
					return false;
		}
		if(middle == end)
			return recur(postorder, start, middle - 1);
		else if(middle == start)
			return recur(postorder, middle, end - 1);
		else
			return recur(postorder, start, middle - 1) && recur(postorder, middle, end - 1);
	}
}
