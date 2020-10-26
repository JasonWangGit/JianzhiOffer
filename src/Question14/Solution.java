package Question14;

// https://leetcode-cn.com/problems/jian-sheng-zi-lcof/

import java.util.Scanner;

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(cuttingRopeByDP(n));
			System.out.println(cuttingRopeByGreedy(n));
		}
		scanner.close();
	}
	
	public static int cuttingRopeByDP(int n) {
		if(n < 0)
			return -1;
		if(n < 2)
			return 0;
		if(n == 2)
			return 1;
		if(n == 3)
			return 2;
		int[] maxArray = new int[n + 1];
		maxArray[1] = 1;
		maxArray[2] = 2;
		maxArray[3] = 3;
		int max;
		for(int i = 4; i <= n; i ++) {
			max = maxArray[i - 1] * maxArray[1];
			for(int j = 2; j <= i / 2; j++)
				max = Math.max(max, (maxArray[i - j]) * maxArray[j]);
			maxArray[i] = max;
		}
		return maxArray[n];
    }
	
	public static int cuttingRopeByGreedy(int n) {
		if(n < 0)
			return -1;
		if(n < 2)
			return 0;
		if(n == 2)
			return 1;
		if(n == 3)
			return 2;
		long result = 1l;
		while(n > 4) {
			n -= 3;
			result *= 3;
			result %= 1000000007;
		}
		if(n == 4) {
			result *= 4;
			result %= 1000000007;
		}
		else {
			result *= n;
			result %= 1000000007;
		}
		return (int) result;	
    }
}
