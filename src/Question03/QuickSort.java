package Question03;

public class QuickSort {
	public static int[] sort(int[] nums) {
		recur(nums, 0, nums.length - 1);
		return nums;
	}
	
	public static void recur(int[] nums, int left, int right) {
		if(left < right) {
			int middle = split(nums, left, right);
			recur(nums, left, middle - 1);
			recur(nums, middle + 1, right);
		}
	}
	
	public static int split(int[] nums, int left, int right) {
		int center = nums[left];
		int i = left + 1;
		int j = right;
		while(true) {
			while(nums[i] <= center && i < right)
				i++;
			while(nums[j] > center && j > left)
				j--;
			if(i < j)
				swap(nums, i, j);
			else {
				swap(nums, left, j);
				break;
			}
		}
		return j;
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
