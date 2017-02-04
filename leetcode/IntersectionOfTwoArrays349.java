package zsz.develop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * 349. Intersection of Two Arrays 
		Difficulty: Easy
		Given two arrays, write a function to compute their intersection.
		
		Example:
		Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
			Note:
			Each element in the result must be unique.
			The result can be in any order.

		349。两个数组的交集
		难度：容易
		给出两个数组，写一个函数来计算它们的交集。
		
		例子:
		鉴于nums1 = [ 1，2，2，1 ]，nums2 = [ 2，2 ]，返回[ 2 ]。
		注：
		结果中的每个元素都必须是唯一的。
		结果可以是任意顺序的。
		
 * @author zhangsz
 *
 */
public class IntersectionOfTwoArrays349 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1,3};
		int[] nums2 = {2,2,3};
		int[] intersection = intersectionOtherOne(nums1, nums2);
		for(int a:intersection){
			System.err.println( "重合的数组"+a);
		}
		
	}

	
	
	/**
	 * 对于题目的理解就有问题，交集并不需要保持顺序关系
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersectionMyOne(int[] nums1, int[] nums2) {
		return null;
	}
	
	/**
	 * 分别建立两个hashset，来装数据
	 *  第一个hashset将 nums1 的所有元素装进st1
	 *  循环遍历出nums2 的数据元素，如果包含在内的话，才添加进st2:所以说st2 是nums1 和nums2 中共有的数据
	 *  且set 可以保证只出现一次
	 * 最后构建出一个新数组，将st2 以数组的形式输出
	 * 
	 *  O(n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersectionOtherOne(int[] nums1, int[] nums2) {
		Set<Integer> st1=new HashSet<Integer>();
		Set<Integer> st2=new HashSet<Integer>();
		for(int a:nums1){
			st1.add(a);
		}
		for(int b: nums2){
			if(st1.contains(b))
				st2.add(b);
		}
		int[] res=new int[st2.size()];
		int i=0;
		for(int a: st2){
			res[i++]=a;
		}
		
		return res;
	}
	
	
	/**
	 * 这里的算法也很精妙，先将nums1 和 nums2进行一个排序
	 * 然后进行一个比较
	 *  分别定义两个索引，记录查询位置
	 *  当nums1《num2时 	num1的索引+1 
	 *  当nums1》num2时 	num2的索引+1 
	 *  相同时，才添加进set 中
	 *  当两个都结束时跳出循环
	 *  
	 *  
	 *  O(nlogn)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	  public int[] intersectionOtherTwo(int[] nums1, int[] nums2) {
	        Set<Integer> set = new HashSet<>();
	        Arrays.sort(nums1);
	        Arrays.sort(nums2);
	        int i = 0;
	        int j = 0;
	        while (i < nums1.length && j < nums2.length) {
	            if (nums1[i] < nums2[j]) {
	                i++;
	            } else if (nums1[i] > nums2[j]) {
	                j++;
	            } else {
	                set.add(nums1[i]);
	                i++;
	                j++;
	            }
	        }
	        int[] result = new int[set.size()];
	        int k = 0;
	        for (Integer num : set) {
	            result[k++] = num;
	        }
	        return result;
	    }
	  
	  
	  /**
	   * 利用二分查找，判断数组里面是否有值，有值添加
	   * 
	   * @param nums1
	   * @param nums2
	   * @return
	   */
	  public int[] intersectionOtherThree(int[] nums1, int[] nums2) {
	        Set<Integer> set = new HashSet<>();
	        Arrays.sort(nums2);
	        for (Integer num : nums1) {
	            if (binarySearch(nums2, num)) {
	                set.add(num);
	            }
	        }
	        int i = 0;
	        int[] result = new int[set.size()];
	        for (Integer num : set) {
	            result[i++] = num;
	        }
	        return result;
	    }

	    public boolean binarySearch(int[] nums, int target) {
	        int low = 0;
	        int high = nums.length - 1;
	        while (low <= high) {
	            int mid = low + (high - low) / 2;
	            if (nums[mid] == target) {
	                return true;
	            }
	            if (nums[mid] > target) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        }
	        return false;
	    }
}
