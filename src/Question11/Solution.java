package Question11;

// https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		int[] array = {2, 2, 2, 0, 1};
		System.out.println(minArray(array));
	}
	
	public static int minArray(int[] numbers) {
		int lower = 0;
		int upper = numbers.length - 1;
		int middle;
		if(numbers[lower] < numbers[upper]) {
			return numbers[lower];
		}
		boolean equalFlag = false;
		while(lower < upper - 1) {
			middle = lower + (upper - lower) / 2;
			if(numbers[lower] == numbers[middle] && numbers[middle] == numbers[upper]) {
				equalFlag = true;
				break;
			}
			if(numbers[middle] >= numbers[lower]) {
				lower = middle;
			} 
			if(numbers[middle] <= numbers[upper]) {
				upper = middle;
			}
		}
		if(equalFlag) {
			int min = numbers[lower];
			for(int i = lower; i <= upper; i++) {
				min = Math.min(min, numbers[i]);
			}
			return min;
		}
		return numbers[upper];
    }
}
