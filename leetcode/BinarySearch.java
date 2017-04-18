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
		// ��һ��λ��
		int low = 0;
		   //���λ��.���鳤��-1,��Ϊ�±��Ǵ�0��ʼ��.  
		int high = arrs.length -1;
		 //��low"ָ��"��high���ظ���ʱ��.  
		while(low <= high){
			//�м�λ�ü���,low+ ���λ�ü�ȥ���λ��,����һλ,�൱�ڳ�2.Ҳ������(high+low)/2
			int mid = low+ (high-low)/2;
			//�����м�����ֽ����ж�,�Ƿ����,��ȵĻ��ͷ��ض�Ӧ�������±�.  
			if (target == arrs[mid]) {
				return mid;
				//���С�ڵĻ����ƶ���߲��"ָ��"  
			}else if (target < arrs[mid]) {
				high = mid -1;
			}else {
				low = mid+1;
			}
		}
		
		return -1;
	}
	

}
