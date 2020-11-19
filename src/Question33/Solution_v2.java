package Question33;

// https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/

public class Solution_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		// int[] postorder = {5, 7, 6, 9, 11, 10, 8};
		// int[] postorder = {7, 4, 5, 6};
		// int[] postorder = new int[0];
		// int[] postorder = {1, 2, 5, 10, 6, 9, 4, 3};
		int[] postorder = {4, 8, 6, 12, 16, 14, 10};
		System.out.println(verifyPostorder(postorder));
	}
	
	public static boolean verifyPostorder(int[] postorder) {
		if(postorder == null || postorder.length == 0) return true;
	    return recur(postorder, 0, postorder.length - 1);
    }
	
	public static boolean recur(int [] postorder, int start, int end) {
		if(start == end) return true;
	    boolean middleFlag = true;
	    int middle = end;
	    int rootVal = postorder[end];
	    for(int i = start; i < end; i++) {
	        if(middleFlag && postorder[i] > rootVal) {
	            middle = i;
	            middleFlag = false;
	        } else if(!middleFlag) {
	            if(postorder[i] < rootVal) return false;
	        }
	    }
	    if(middle == start) return recur(postorder, middle, end - 1);
	    else if(middle == end) return recur(postorder, start, middle - 1);
	    else return recur(postorder, start, middle - 1) && recur(postorder, middle, end - 1);
	}
}
