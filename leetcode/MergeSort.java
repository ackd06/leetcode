package com.zszdevelop.algorithms.mergesort;

public class MergeSort {
	static int number=0;
	
	  public static void main(String[] args) {
	        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
	        printArray("����ǰ��",a);
	        sort(a);
	        printArray("�����",a);
	    }
	
	private static void printArray(String pre,int[] a) {
	        System.out.print(pre+"\n");
	        for(int i=0;i<a.length;i++)
	            System.out.print(a[i]+"\t");    
	        System.out.println();
	    }
	
	  private static void sort(int[] a) {
			System.out.println("��ʼ����");
			mSort(a,0,a.length -1);
			
		}

	private static void mSort(int[] arrs, int left, int right) {
		if (left>=right) {
			return;
		}
		int mid = (left+ right)/2;
		// ��·�鲢��������������sort����·�鲢��������д���sort �Ϳ�����
		mSort(arrs, left, mid);
		mSort(arrs, mid+1, right);
		merge(arrs,left,mid,right);
	}

	private static void merge(int[] arrs, int left, int mid, int right) {
		int[] temp = new int[arrs.length];
		int r1 = mid +1;
		int tIndex = left;
		int cIndex = left;
		//����鲢
		while(left<=mid && r1 <= right){
			if (arrs[left] <= arrs[r1]) {
				temp[tIndex++] = arrs[left++];
			}else {
				temp[tIndex++] = arrs[r1++];
			}
			
		}
		
		//�����ʣ��Ĺ鲢
		while(left<=mid){
			temp[tIndex++] = arrs[left++];
			
		}
		//���ұ�ʣ��Ĺ鲢
		while(r1 <= right){
			temp[tIndex++] = arrs[r1++];
		}
		
		System.out.println("��"+(++number)+"������:\t");
		//����ʱ���鿽����ԭ����
		while(cIndex<=right){
			arrs[cIndex] = temp[cIndex];
			//����м�鲢����ṹ
			System.out.print(arrs[cIndex] +"\t");
			cIndex++;
		}
		System.out.println();
	}
}
