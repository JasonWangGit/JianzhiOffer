package Question40;

public class QuickSort {
	public static void sort(int[] nums) {
		recur(nums, 0, nums.length - 1);
	}
	
	public static void recur(int[] nums, int start, int end) {
		if(start < end) {
			int middle = split(nums, start, end);
			recur(nums, start, middle - 1);
			recur(nums, middle + 1, end);
		}
	}
	
	public static int split(int[] nums, int start, int end) {
		if(start == end)
			return start;
		int middleVal = nums[start];
		int i = start + 1;
		int j = end;
		while(true) {
			while(nums[i] <= middleVal && i < end)
				i++;
			while(nums[j] > middleVal && j > start)
				j--;
			if(i < j)
				swap(nums, i, j);
			else
				break;
		}
		swap(nums, start, j);
		return j;
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}