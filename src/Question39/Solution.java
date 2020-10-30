package Question39;

// https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
		System.out.println(majorityElementBySplit(nums));
	}
	
	public static int majorityElement(int[] nums) {
		if(!isValidArray(nums))
			return -1;
		int count = 1;
		int result = nums[0];
		for(int i = 1; i < nums.length; i++) {
			if(count == 0) {
				result = nums[i];
				count = 1;
			} else
				if(nums[i] != result)
					count--;
				else
					count++;
		}
		if(!isMoreThanHalf(nums, result))
			return -1;
		return result;
    }
	
	public static int majorityElementBySplit(int[] nums) {
		if(!isValidArray(nums))
			return -1;
		int middle = nums.length >> 1;
		int start = 0;
		int end = nums.length - 1;
		int index = QuickSort.split(nums, start, end);
		while(index != middle)
			if(index > middle) {
				end = index - 1;
				index = QuickSort.split(nums, start, end);
			} else {
				start = index + 1;
				index = QuickSort.split(nums, start, end);
			}
		if(!isMoreThanHalf(nums, nums[index]))
			return -1;
		return nums[index];
    }
	
	public static boolean isValidArray(int[] nums) {
		if(nums == null || nums.length == 0)
			return false;
		return true;
	}
	
	public static boolean isMoreThanHalf(int[] nums, int target) {
		int count = 0;
		for(int i : nums)
			if(i == target)
				count++;
		if((count << 1) > nums.length)
			return true;
		return false;
	}
}
