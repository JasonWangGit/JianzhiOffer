package Question13;

import java.util.Scanner;

// https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			System.out.println(movingCount(m, n, k));
		}
		scanner.close();
	}
	
	public static int movingCount(int m, int n, int k) {
		if(m < 0 || n < 0)
			return -1;
		boolean[][] isVisited = new boolean[m][n];
		return recur(isVisited, k, 0, 0);
    }
	
	public static int recur(boolean[][] isVisited, int k, int i, int j) {
		if(i < 0 || j < 0 || i >= isVisited.length || j >= isVisited[0].length)
			return 0;
		if(isVisited[i][j])
			return 0;
		isVisited[i][j] = true;
		if(isEnterable(k, i, j))
			return 1 + recur(isVisited, k, i - 1, j) + recur(isVisited, k, i + 1, j)
		+ recur(isVisited, k, i, j - 1) + recur(isVisited, k, i, j + 1);
		else
			return 0;

	}
	
	public static boolean isEnterable(int k, int i, int j) {
		int digitSum = 0;
		while(i != 0) {
			digitSum += i % 10;
			i /= 10;
		}
		while(j != 0) {
			digitSum += j % 10;
			j /= 10;
		}
		if(digitSum > k)
			return false;
		else
			return true;
	}
}
