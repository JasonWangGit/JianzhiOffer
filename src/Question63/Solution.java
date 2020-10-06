package Question63;

// https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		int[] array = {9, 11, 8, 5, 7, 12, 16, 14};
		System.out.println(maxProfit(array));
	}

	public static int maxProfit(int[] prices) {
		if(prices.length == 0) {
			return 0;
		}
		int min = prices[0];
		int diff = 0;
		for(int i : prices) {
			min = Math.min(i, min);
			diff = Math.max(i - min, diff);
		}
		return diff;
	}
}