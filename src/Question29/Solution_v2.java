package Question29;

// https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/

public class Solution_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		// int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		spiralOrder(matrix);
	}
	
	public static int[] spiralOrder(int[][] matrix) {
		if(matrix == null)
			return null;
		if(matrix.length == 0 || matrix[0].length == 0)
			return new int[0];
		int colEnd = matrix[0].length;
		int rowEnd = matrix.length;
		int[] result = new int[colEnd-- * rowEnd--];
		int start = 0;
		int index = 0;
		while(matrix[0].length > 2 * start && matrix.length > 2 * start)
			index = printer(result, matrix, start++, colEnd--, rowEnd--, index);
		return result;
    }
	
	public static int printer(int[] result, int[][] matrix, 
			int start, int colEnd, int rowEnd, int index) {
		if(colEnd >= start)
			for(int i = start; i <= colEnd; i++)
				result[index++] = matrix[start][i];
		if(rowEnd > start)
			for(int i = start + 1; i <= rowEnd; i++)
				result[index++] = matrix[i][colEnd];
		if(colEnd > start && rowEnd > start)
			for(int i = colEnd - 1; i >= start; i--)
				result[index++] = matrix[rowEnd][i];
		if(colEnd > start && rowEnd > start + 1)
			for(int i = rowEnd - 1; i > start; i--)
				result[index++] = matrix[i][start];
		return index;
	}
}
