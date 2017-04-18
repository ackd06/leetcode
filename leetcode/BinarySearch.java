package com.zszdevelop.algorithms.binarysearch;

public class BinarySearch {

	public int sort(int[] arrs, int target) {
		int index = bSortRecursion(arrs, 0, arrs.length -1, target);

		return index;
	}

	private int bSortRecursion(int[] arrs, int low, int high, int target) {
		
		if (low <= high) {
			int mid = (low + high) / 2;
			if (arrs[mid] == target) {
				return mid;
			} else if ( target <arrs[mid]) {
				return bSortRecursion(arrs, low, mid - 1, target);
			} else if (target > arrs[mid] ) {
				return bSortRecursion(arrs, mid + 1, high, target);
			}
		}

		return -1;

	}
	
	private int bSortLoop(int[] arrs,int target){
		// 第一个位置
		int low = 0;
		   //最高位置.数组长度-1,因为下标是从0开始的.  
		int high = arrs.length -1;
		 //当low"指针"和high不重复的时候.  
		while(low <= high){
			//中间位置计算,low+ 最高位置减去最低位置,右移一位,相当于除2.也可以用(high+low)/2
			int mid = low+ (high-low)/2;
			//与最中间的数字进行判断,是否相等,相等的话就返回对应的数组下标.  
			if (target == arrs[mid]) {
				return mid;
				//如果小于的话则移动最高层的"指针"  
			}else if (target < arrs[mid]) {
				high = mid -1;
			}else {
				low = mid+1;
			}
		}
		
		return -1;
	}
	

}
