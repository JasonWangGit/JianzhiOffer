package Question15;

// https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/

import java.util.Scanner;

public class Solution_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(hammingWeightByRightShift(n));
			System.out.println(hammingWeight(n));
		}
		scanner.close();
	}
	
	public static int hammingWeightByRightShift(int n) {
		int count = 0;
		while(n != 0) {
			if((n & 1) != 0)
				count++;
			n >>>= 1;
		}
		return count;
	}
	
	public static int hammingWeight(int n) {
		int count = 0;
		while(n != 0) {
			n &= n - 1;
			count++;
		}
		return count;
	}
}
