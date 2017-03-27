package zsz.develop.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Remove Element
 * 
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * Example: Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 2.
 * 
 * 删除元素 给定一个数组和一个值，删除该值的所有实例，并返回新的长度。 不要为另一个数组分配额外的空间，您必须使用常量内存来进行此操作。
 * 元素的顺序可以改变。 没有什么你离开超过新的长度。 例： 给定输入数组nums = [3,2,2,3]，val = 3
 * 
 * 你的函数应该返回length = 2，num的前两个元素是2。
 * 
 * @author zhangsz
 *
 */
public class RemoveElement {

	public int removeElementMyone(int[] nums, int val) {
		// List<Integer> list = new ArrayList<>();
		int same = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {//
				nums[same++] = nums[i];

			}
		}
		return nums.length - same;
	}

	
	/**
	 * 想法还是很好的，循环对比，如果与目标元素不相等，那么就用将该元素添加进指定的索引
	 * @param A
	 * @param val
	 * @return
	 */
	public int removeElementOtherOne(int[] A, int val) {
		int begin = 0;
		for (int i = 0; i < A.length; i++)
			if (A[i] != val)
				// begin++ 是先赋值，再加
				A[begin++] = A[i];
		return begin;
	}
}
