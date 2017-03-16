package zsz.develop.three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * 两个和
 * 
 * 给定一个整数数组，返回两个数字的索引，使得它们加起来成为一个特定的目标。
 * 
 * 您可以假设每个输入都有一个解决方案，您不能使用相同的元素两次。
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author zhangsz
 *
 */
public class TwoSum {

	/**
	 * 先假设他是已经排序的,暂无思路
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSumMyOne(int[] nums, int target) {
		Arrays.sort(nums);
		int shengyu = target;
		while (shengyu!=0) {
//			nums[0]
			
		}
		return nums;
	}
	
	
	/**
	 * 这个解法还是很清晰的
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSumOtherOne(int[] numbers, int target) {
	    int[] result = new int[2];//返回的肯定是一个二维数组
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();//利用map，只能使用一次的特点
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {// 这一步就比较巧妙了，如果目标减当前值等于之前在数组里面的值，就正好是一对
	        	// 这里返回的是数组的索引，所以使用map 来存取他的值
	            result[1] = i;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i);
	    }
	    return result;
	}
}
