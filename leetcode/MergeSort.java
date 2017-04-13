package com.zszdevelop.algorithms.mergesort;

public class MergeSort {
	static int number=0;
	
	  public static void main(String[] args) {
	        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
	        printArray("排序前：",a);
	        sort(a);
	        printArray("排序后：",a);
	    }
	
	private static void printArray(String pre,int[] a) {
	        System.out.print(pre+"\n");
	        for(int i=0;i<a.length;i++)
	            System.out.print(a[i]+"\t");    
	        System.out.println();
	    }
	
	  private static void sort(int[] a) {
			System.out.println("开始排序");
			mSort(a,0,a.length -1);
			
		}

	private static void mSort(int[] arrs, int left, int right) {
		if (left>=right) {
			return;
		}
		int mid = (left+ right)/2;
		// 二路归并排序里面有两个sort，多路归并排序里面写多个sort 就可以了
		mSort(arrs, left, mid);
		mSort(arrs, mid+1, right);
		merge(arrs,left,mid,right);
	}

	private static void merge(int[] arrs, int left, int mid, int right) {
		int[] temp = new int[arrs.length];
		int r1 = mid +1;
		int tIndex = left;
		int cIndex = left;
		//逐个归并
		while(left<=mid && r1 <= right){
			if (arrs[left] <= arrs[r1]) {
				temp[tIndex++] = arrs[left++];
			}else {
				temp[tIndex++] = arrs[r1++];
			}
			
		}
		
		//将左边剩余的归并
		while(left<=mid){
			temp[tIndex++] = arrs[left++];
			
		}
		//将右边剩余的归并
		while(r1 <= right){
			temp[tIndex++] = arrs[r1++];
		}
		
		System.out.println("第"+(++number)+"趟排序:\t");
		//从临时数组拷贝到原数组
		while(cIndex<=right){
			arrs[cIndex] = temp[cIndex];
			//输出中间归并排序结构
			System.out.print(arrs[cIndex] +"\t");
			cIndex++;
		}
		System.out.println();
	}
}
