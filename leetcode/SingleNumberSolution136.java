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
 * 136。单一的数字questioneditorial解我的意见 难度：容易 给定一个整数数组，每一个元素都会出现两次，除了一个。找到那个单身的。 注：
 * 你的算法应该有一个线性的运行时复杂度。你能实现它而不使用额外的内存吗？
 * 
 * @author zhangsz
 *
 */
public class SingleNumberSolution136 {

	
	/**
	 * 第一种蛮力算法，先理解一下思路
	 * 	第一遍循环 取出每个元素，标记当前元素为 isSingle = true
	 * 	第二遍循环取出除了自己是否还有其他元素与自身相等  isSingle = false
	 * 	若到最后还为true，那么他肯定就是单数，返回
	 * 	算法复杂度为O(n^2)
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
	 * 第二种解法
	 * 
	 * 	给的提示时：hashTable 和位运算，毫无思路
	 * 
	 * @param nums
	 * @return
	 */
	public static int singleNumberMyTwo(int[] nums) {
		
	return 0;
	}

	
	/**
	 * 利用hashSet不能有重复元素的特性实现
	 * 	当添加set 不成功的时候，说明已经有存在的元素了，所以移除元素
	 * 	那么剩下来的就是只有一个的元素
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
	 * 利用   异或运算符^		两个操作数的位中，相同则结果为0，不同则结果为1。
	 * 	不是很懂这个方案
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
//	 * 利用   异或运算符^		两个操作数的位中，相同则结果为0，不同则结果为1。
//	 * 	不是很懂这个方案
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
