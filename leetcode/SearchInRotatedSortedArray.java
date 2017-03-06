package zsz.develop.two;

/**
 * Search in Rotated Sorted Array Suppose an array sorted in ascending order is
 * rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Subscribe to see which companies asked this question.
 * 
 * 
 * 假设一个按升序排序的数组在你事先未知的某个旋转点旋转。 (i.e., 0 1 2 4 5 6 7 可能成为 4 5 6 7 0 1 2).
 * 给你一个搜索的目标值。如果在数组中找到返回它的索引，否则返回- 1。 您可以假定数组中不存在重复。 订阅，看看哪些公司问这个问题。
 * 
 * @author zhangsz
 *
 */
public class SearchInRotatedSortedArray {

	
	
	/**
	 * 遇到一个问题，目标节点不是有序的，不能用二分查找，
	 * 但是他是有序节点的旋转
	 * 
	 * 
	 * 还真是小伙呆，根本不需要考虑上面的点，直接循环又找到的话，就返回当前索引
	 * 但是这个方法的算法复杂度为n
	 * @param nums
	 * @param target
	 * @return
	 */
	public int searchMyOne(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] >nums[i+1]) {
//				
//			}
			if (nums[i] == target) {
				return i;
			}
		}
//		binarySearch(nums, target);
		return -1;
	}

//	private int binarySearch(int[] nums, int target) {
//		int low = nums[0];
//		int high = nums[nums.length];
//		while (low < high) {
//			int middle = (low + high) / 2;
//			if (target == nums[middle]) {
//				return middle;
//			} else if (target < nums[middle]) {
//				high = nums[middle];
//			} else if (target > nums[middle]) {
//				low = nums[middle];
//
//			}
//
//		}
//
//		return -1;
//	}
	
	
	
	/**
	 * 
	 * @param A
	 * @param target
	 * @return
	 */
	public int searchOtherOne(int[] A, int target) {
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] == target) return mid;
	        
	        if (A[lo] <= A[mid]) {//判断是否为同序
	            if (target >= A[lo] && target < A[mid]) {//主要是这两个判断，判断是否在这个子区间中
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else {
	            if (target > A[mid] && target <= A[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
	    return A[lo] == target ? lo : -1;
	}
	
}
