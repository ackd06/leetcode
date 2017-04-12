package com.zszdevelop.algorithms;

public class QuickSort {

	public static void main(String[] args) {
		int[] nums = {5,7,3,4};
		quick(nums,0,nums.length -1);
		for(int i: nums){
			System.out.println(i+"");
		}
	}

	private static void quick(int[] nums, int low, int high) {
		if (low<high) {
			int pivot=partition(nums, low, high);  //将数组分为两部分
			quick(nums, low, pivot-1);//递归排序左子数组
			quick(nums, pivot+1, high);//递归排序右子数组
		}
		
		
	}

	private static int partition(int[] nums, int low, int high) {
		int pivot = nums[low];//记录枢轴
		while (low<high) {
			while (low<high&&nums[high]>= pivot) {//不断循环，如果目标大于枢轴，就减去一个
				--high;
			}
			nums[low] = nums[high];//交换比枢轴小的记录到左端
			while (low< high && nums[low] <= pivot) {
				++low;
			}
			nums[high] = nums[low];// 交换比枢轴大的记录到右端
		}
		  //扫描完成，枢轴到位
		nums[low] = pivot;
		  //返回的是枢轴的位置
		return low;
	}

	
}
