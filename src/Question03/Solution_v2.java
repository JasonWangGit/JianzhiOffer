package Question03;

import java.util.HashSet;

//https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/

public class Solution_v2 {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		// int[] nums = { 2, 3, 1, 0, 2, 5, 3 };
		int[] nums = { 2, -3, 1, 0, 2, 88, 3 };
		// System.out.println(findRepeatNumberByQuickSort(nums));
		// System.out.println(findRepeatNumberByHashTable(nums));
		System.out.println(findRepeatNumber(nums));
	}
	
	// by QuickSort
	public static int findRepeatNumberByQuickSort(int[] nums) {
		nums = QuickSort.sort(nums);
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i + 1])
				return nums[i];
		}
		return -1;
	}
	
	// by HashTable
	public static int findRepeatNumberByHashTable(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		for(int i : nums) {
			if(hashSet.contains(i))
				return i;
			hashSet.add(i);
		}
		return -1;
	}
	
	// by Compare
	public static int findRepeatNumber(int[] nums) {
		if(nums == null)
			return -1;
		for(int i : nums)
			if(i < 0 || i >= nums.length)
				return -1;
		for(int i = 0; i < nums.length; i++) {
			while(nums[i] != i) {
				if(nums[i] != nums[nums[i]])
					QuickSort.swap(nums, nums[i], i);
				else
					return nums[i];
			}
		}
		return -1;
	}
}
