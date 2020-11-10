package Question40;

import java.util.Map;
import java.util.TreeMap;

// https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/

public class Solution {
	// main() just for test, if you wanna submit on leetcode, reference to the
	// function() beneath main()
	public static void main(String[] args) {
		// int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
		int[] nums = {0, 0, 2, 3, 2, 1, 1, 2, 0, 4};
		// int[] nums = {0, 0, 2, 0, 5};
		int[] result = getLeastNumbers(nums, 8);
		for(int i : result)
			System.out.print(i + " ");
	}
	
	public static int[] getLeastNumbers(int[] arr, int k) {
		if(arr == null)
			return null;
		if(arr.length == 0 || k <=0)
			return new int[0];
		if(k > arr.length)
			return arr;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(i < k)
				treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
			else {
				Map.Entry<Integer, Integer> lastEntry = treeMap.lastEntry();
				if(arr[i] < lastEntry.getKey()) {
					treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);
					if(lastEntry.getValue() == 1)
						treeMap.pollLastEntry();
					else
						treeMap.put(lastEntry.getKey(), lastEntry.getValue() - 1);
				}
			}
		}
		int[] result = new int[k];
		int i = 0;
		for(Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
			for(int j = 0; j < entry.getValue(); j++)
				result[i++] = entry.getKey();
		}
		return result;
    }
	
	public static int[] getLeastNumbersBySplit(int[] arr, int k) {
		if(arr == null)
			return null;
		if(arr.length == 0 || k <=0)
			return new int[0];
		if(k > arr.length)
			return arr;
		int start = 0;
		int end = arr.length - 1;
		int middle = QuickSort.split(arr, start, end);
        while(middle + 1 != k) {
        	if(middle + 1> k) {
        		end = middle - 1;
        		middle = QuickSort.split(arr, start, end);
        	} else {
        		start = middle + 1;
        		middle = QuickSort.split(arr, start, end);
        	}
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++)
        	result[i] = arr[i];
        return result;
    }
}