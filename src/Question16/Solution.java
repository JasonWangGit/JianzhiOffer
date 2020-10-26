package Question16;

import java.util.Scanner;

// https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			double x = scanner.nextDouble();
			int n = scanner.nextInt();
			// System.out.println(myPow(x, n));
			// System.out.println(myPowByRecur(x, n));
			System.out.println(myPowByLoop(x, n));
		}
		scanner.close();
	}
	
	public static double myPow(double x, int n) {
		double result = 1;
		if(n == 0 && isEqual(x, 0.0))
			return 0.0;
		if(n == 0 && !isEqual(x, 0.0) || isEqual(x, 1.0))
			return 1.0;
		if(n > 0)
			for(int i = 0; i < n; i++)
				result *= x;
		else
			for(int i = 0; i < -n; i++)
				result /= x;
		return result;
    }
	
	public static double myPowByLoop(double x, int n) {
		double result = 1;
		long p = n;
		if(p == 0 && isEqual(x, 0.0))
			return 0.0;
		if(p == 0 && !isEqual(x, 0.0))
			return 1.0;
		if(p < 0) {
			x = 1 / x;
			p = -p;
		}
		while(p > 0) {
			if((p & 1) == 1)
				result *= x;
			x *= x;
			p >>= 1;
		}
		return result;
    }
	
	public static double myPowByRecur(double x, int n) {
		double result = 1;
		if(n == 0 && isEqual(x, 0.0))
			return 0.0;
		if(n == 0 && !isEqual(x, 0.0))
			return 1.0;
		if(n > 0)
			result = recur(x, n);
		else
			result = 1 / recur(x, -n);
		return result;
    }
	
	public static double recur(double x, int n) {
		if(n == 0)
			return 1.0;
		if(n == 1)
			return x;
		double result = recur(x, n >> 1);
		result *= result;
		if((n & 1) == 1)
			result *= x;
		return result;
	}
	
	public static boolean isEqual(double a, double b) {
		if(a - b < 0.0000001 && a - b > -0.0000001)
			return true;
		else
			return false;
	}
}
