package Question11;

// https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/

public class Solution_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		// int[] numbers = {3, 4, 5, 1, 2};
		// int[] numbers = {1, 2, 3, 4, 5};
		// int[] numbers = {1, 0, 1, 1, 1};
		int[] numbers = new int[0];
		
		System.out.println(minArray(numbers));
	}

	public static int minArray(int[] numbers) {
		if(numbers == null || numbers.length == 0)
			return -1;
		if(numbers[0] < numbers[numbers.length - 1])
			return numbers[0];
		int left = 0;
		int right = numbers.length - 1;
		int middle = 0;
		while(left != right - 1) {
			middle = (left + right) / 2;
			if(numbers[middle] == numbers[left] && numbers[middle] == numbers[right]) {
				int min = numbers[0];
				for(int i : numbers) {
					min = Math.min(min, i);
				}
				return min;
			}
			if(numbers[middle] >= numbers[left])
				left = middle;
			if(numbers[middle] <= numbers[right])
				right = middle;
		}
		return numbers[right];
	}
}
