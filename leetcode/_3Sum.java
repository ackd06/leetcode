package zsz.develop.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 3Sum Given an array S of n integers, are there elements a, b, c in S such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * 3Sum 给定n个整数的数组S，在S中存在元素a，b，c，使得a + b + c = 找到数组中所有唯一的三元组，它给出零的和。
 * 
 * 注意：解决方案集不能包含重复的三元组。
 * 
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],

	A solution set is:
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
 * @author zhangsz
 *
 */
public class _3Sum {
	/**
	 * 没什么思路
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();
		return lists;
	}
	
	
	/**
	 * 直接参考大神的，积累经验
	 * @param num
	 * @return
	 */
	public List<List<Integer>> threeSumOtherOne(int[] num) {
	    Arrays.sort(num);//先对数组进行排序
	    List<List<Integer>> res = new LinkedList<>();
	    for (int i = 0; i < num.length-2; i++) {//遍历这个三元组可能的第一个元素
	    	//对于每个可能的第一元素，我们对阵列的剩余部分进行标准的双向2Sum扫描。 另外，我们想跳过等于元素，以避免重复的答案，而不做一个设置或smth这样。
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) { 	 
	        	int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
}
