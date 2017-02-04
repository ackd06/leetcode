package zsz.develop;

import java.util.HashSet;
import java.util.Set;

/**
 * 136. Single Number QuestionEditorial Solution My Submissions Difficulty: Easy
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * 
 * 136����һ������questioneditorial���ҵ���� �Ѷȣ����� ����һ���������飬ÿһ��Ԫ�ض���������Σ�����һ�����ҵ��Ǹ�����ġ� ע��
 * ����㷨Ӧ����һ�����Ե�����ʱ���Ӷȡ�����ʵ��������ʹ�ö�����ڴ���
 * 
 * @author zhangsz
 *
 */
public class SingleNumberSolution136 {

	
	/**
	 * ��һ�������㷨�������һ��˼·
	 * 	��һ��ѭ�� ȡ��ÿ��Ԫ�أ���ǵ�ǰԪ��Ϊ isSingle = true
	 * 	�ڶ���ѭ��ȡ�������Լ��Ƿ�������Ԫ�����������  isSingle = false
	 * 	�������Ϊtrue����ô���϶����ǵ���������
	 * 	�㷨���Ӷ�ΪO(n^2)
	 * @param nums
	 * @return
	 */
	public static int singleNumberMyOne(int[] nums) {

		int length = nums.length;
		for(int i = 0;i<length;i++){
			int k = nums[i];
			int tempI = i;
			boolean isSingle = true;
			for (int j = 0; j < nums.length; j++) {
				if (j!=tempI && k == nums[j]) {
					isSingle = false;
				}
			}
			if (isSingle) {
				return k;
			}
		}
		
		return 0;
	}
	
	
	
	/**
	 * �ڶ��ֽⷨ
	 * 
	 * 	������ʾʱ��hashTable ��λ���㣬����˼·
	 * 
	 * @param nums
	 * @return
	 */
	public static int singleNumberMyTwo(int[] nums) {
		
	return 0;
	}

	
	/**
	 * ����hashSet�������ظ�Ԫ�ص�����ʵ��
	 * 	�����set ���ɹ���ʱ��˵���Ѿ��д��ڵ�Ԫ���ˣ������Ƴ�Ԫ��
	 * 	��ôʣ�����ľ���ֻ��һ����Ԫ��
	 * 	
	 * O(n)
	 * @param nums
	 * @return
	 */
	public static int singleNumberOtherOne(int[] nums) {
		 Set<Integer> s = new HashSet<>();
		    for (int i = 0; i < nums.length; i++)
		            if (!s.add(nums[i])) s.remove(nums[i]);
		    return s.iterator().next();
	}
	/**
	 * ����   ��������^		������������λ�У���ͬ����Ϊ0����ͬ����Ϊ1��
	 * 	���Ǻܶ��������
	 * 
	 * @param nums
	 * @return
	 */
	public static int singleNumberOtherTwo(int[] nums) {
		 int result = 0;
		    for (int num : nums) {
		        result ^= num;
		    }
		    return result;
	}
	
//	/**
//	 * ����   ��������^		������������λ�У���ͬ����Ϊ0����ͬ����Ϊ1��
//	 * 	���Ǻܶ��������
//	 * 
//	 * @param nums
//	 * @return
//	 */
//	public static int singleNumberOtherThere(int[] nums) {
//	
//		    int j=nums[0],k;
//		    for(k=1;k<nums.length-1;k++)
//		        j^=nums[k];
//		    return j;
//		
//	}
	
	
	
	
	
}
