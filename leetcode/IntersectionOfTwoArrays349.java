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

		349����������Ľ���
		�Ѷȣ�����
		�����������飬дһ���������������ǵĽ�����
		
		����:
		����nums1 = [ 1��2��2��1 ]��nums2 = [ 2��2 ]������[ 2 ]��
		ע��
		����е�ÿ��Ԫ�ض�������Ψһ�ġ�
		�������������˳��ġ�
		
 * @author zhangsz
 *
 */
public class IntersectionOfTwoArrays349 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1,3};
		int[] nums2 = {2,2,3};
		int[] intersection = intersectionOtherOne(nums1, nums2);
		for(int a:intersection){
			System.err.println( "�غϵ�����"+a);
		}
		
	}

	
	
	/**
	 * ������Ŀ�����������⣬����������Ҫ����˳���ϵ
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersectionMyOne(int[] nums1, int[] nums2) {
		return null;
	}
	
	/**
	 * �ֱ�������hashset����װ����
	 *  ��һ��hashset�� nums1 ������Ԫ��װ��st1
	 *  ѭ��������nums2 ������Ԫ�أ�����������ڵĻ�������ӽ�st2:����˵st2 ��nums1 ��nums2 �й��е�����
	 *  ��set ���Ա�ֻ֤����һ��
	 * ��󹹽���һ�������飬��st2 ���������ʽ���
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
	 * ������㷨Ҳ�ܾ���Ƚ�nums1 �� nums2����һ������
	 * Ȼ�����һ���Ƚ�
	 *  �ֱ���������������¼��ѯλ��
	 *  ��nums1��num2ʱ 	num1������+1 
	 *  ��nums1��num2ʱ 	num2������+1 
	 *  ��ͬʱ������ӽ�set ��
	 *  ������������ʱ����ѭ��
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
	   * ���ö��ֲ��ң��ж����������Ƿ���ֵ����ֵ���
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
