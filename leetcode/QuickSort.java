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
			int pivot=partition(nums, low, high);  //�������Ϊ������
			quick(nums, low, pivot-1);//�ݹ�������������
			quick(nums, pivot+1, high);//�ݹ�������������
		}
		
		
	}

	private static int partition(int[] nums, int low, int high) {
		int pivot = nums[low];//��¼����
		while (low<high) {
			while (low<high&&nums[high]>= pivot) {//����ѭ�������Ŀ��������ᣬ�ͼ�ȥһ��
				--high;
			}
			nums[low] = nums[high];//����������С�ļ�¼�����
			while (low< high && nums[low] <= pivot) {
				++low;
			}
			nums[high] = nums[low];// �����������ļ�¼���Ҷ�
		}
		  //ɨ����ɣ����ᵽλ
		nums[low] = pivot;
		  //���ص��������λ��
		return low;
	}

	
}
