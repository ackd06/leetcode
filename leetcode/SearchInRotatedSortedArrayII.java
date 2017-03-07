package zsz.develop.three;

/**
 * Search in Rotated Sorted Array II
 * 
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose an array
 * sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * The array may contain duplicates.
 * 
 * “旋转排序数组中的搜索”： 如果重复是允许的吗？ 这会影响运行时的复杂性吗？如何和为什么？ 假设一个按升序排序的数组在你事先未知的某个旋转点旋转。
 * 2（0，1，5，6，7，可能成为4，6，7，0，1 2）。 编写函数以确定给定的目标是否在数组中。 数组可能包含重复。
 * 
 * @author zhangsz
 *
 */
public class SearchInRotatedSortedArrayII {

	/**
	 * 这里的判断就不够严谨，因为例如【1，3，1，1，1，1，1】
	 * (nums[lo] <= nums[mid]) 这一步开始就存在了问题
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean search(int[] nums, int target) {
		
		if (nums.length == 0) {
			return false;
		}

		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = (lo +hi)/2;
			if (nums[mid]  == target ) {
				return true;
			}
			if (nums[lo] <= nums[mid]) {//转折点在右边，
				if (nums[lo] <= target&&target<nums[mid]) {// 对应全部上升的情况
					hi = mid-1;
				}else {
					lo = mid +1;
				}
			}else {
				if (nums[mid] < target &&target <= nums[hi]) {
					lo = mid +1;
				}else {
					hi = mid -1;
				}
			}
 		}

		return nums[lo] ==target?true:false;

	}

	
	public boolean searchOtherOne(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            //If we know for sure left side is sorted or right side is unsorted
            } else if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        
        return false;
    }

}
