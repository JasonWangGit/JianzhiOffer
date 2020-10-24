package Question04;

// https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		// int[][] matrix = { {1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15} };
		int[][] matrix = {{5}};
		int target = 5;
		// System.out.println(findRepeatNumberByQuickSort(nums));
		// System.out.println(findRepeatNumberByHashTable(nums));
		System.out.println(findNumberIn2DArray(matrix, target));
	}

	public static boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix == null)
			return false;
		if(matrix.length == 0)
			return false;
		int i = 0;
		int j = matrix[0].length - 1;
		while(i < matrix.length && j >= 0) {
			if(target > matrix[i][j])
				i++;
			else if(target < matrix[i][j])
				j--;
			else {
				return true;
			}
		}
		return false;
	}
}
