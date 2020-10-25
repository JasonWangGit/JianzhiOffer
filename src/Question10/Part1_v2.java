package Question10;

import java.util.Scanner;

// https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/

public class Part1_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int n = scanner.nextInt();
			System.out.println(fibByLoop(n));
		}
		scanner.close();
	}
	
	public static int fibByRecur(int n) {
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		return fibByRecur(n - 1) + fibByRecur(n - 2);
    }
	
	public static int fibByLoop(int n) {
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		int fib_0 = 0;
		int fib_1 = 1;
		int fib_n = 0;
		for(int i = 2; i <= n; i++) {
			fib_n = (fib_0 + fib_1) % 1000000007;
			fib_0 = fib_1;
			fib_1 = fib_n;
		}
		return fib_n;
    }
}
