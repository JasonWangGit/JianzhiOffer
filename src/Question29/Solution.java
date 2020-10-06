package Question29;

// https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		spiralOrder(matrix);
	}
	
	public static int[] spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[0];
		}
		int start = 0;
		int right = matrix[0].length - 1;
		int bottom = matrix.length - 1;
		int[] array = new int[matrix.length * matrix[0].length];
		int index = 0;
		while(matrix.length > 2 * start && matrix[0].length > 2 * start) {
			index = printMatrix(array, matrix, start, right, bottom, index);
			start++;
			right--;
			bottom--;
		}
		return array;
    }
	
	public static int printMatrix(int[] array, int[][] matrix, int start, int right, int bottom, int index) {
		for(int i = start; i <= right; i++) {
			//  System.out.print(matrix[start][i] + " ");
			array[index] = matrix[start][i];
			index++;
		}
		
		if(bottom > start) {
			for(int i = start + 1; i <= bottom; i++) {
				// System.out.print(matrix[i][right] + " ");
				array[index] = matrix[i][right];
				index++;
			}
		}
		
		if(bottom > start && right > start) { 
			for(int i = right - 1; i >= start; i--) {
				// System.out.print(matrix[bottom][i] + " ");
				array[index] = matrix[bottom][i];
				index++;
			}
		}
		
		if(bottom > start + 1 && right > start) {
			for(int i = bottom - 1; i > start; i--) {
				// System.out.print(matrix[i][start] + " ");
				array[index] = matrix[i][start];
				index++;
			}
		}
		return index;
	}
}
