package Question15;

import java.util.Scanner;

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int i = scanner.nextInt();
			System.out.println(hammingWeight(i));
		}
		scanner.close();
	}

	public static int hammingWeight(int n) {
		int count = 0;
		while(n != 0) {
			n = (n-1) & n;
			count++;
		}
		return count;
	}
}
