package zsz.develop;


/**
 *  Move Zeroes
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

	For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
	
	Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
	
	
	给定一个数组的数组，写一个函数将所有0的结束它在保持非零元素的相对顺序。
	例如，给定次数= [ 0，1，0，3，12 ]，呼唤你的功能后，你应该[ 1，3，12，0，0 ]。
	注：
	你必须这样做，而不作一个数组的副本。
	尽量减少操作的总数。
 *  
 *  
 * @author zhangsz
 *
 */
public class MoveZeroes {

	// public void moveZeroes(int[] nums) {
	// for(int i = 0;i<nums.length;i++)
	// }
	/**
	 * 解法思路还是错了
	 * 
	 * @param nums
	 * @return
	 */
	public static int[] moveZeroes(int[] nums) {
		int zeroPosition = 0;
		int zeroNumber = 0;
		for (int i = 0; i < nums.length; i++) {
			// if (nums[i] == 0){
			// // 这个是将为零的末项，转移到零的位置
			// int j = nums[nums.length-1 - zeroNumber];
			// nums[i] = j;
			// nums[nums.length-1 - zeroNumber] =0;
			// zeroNumber++;
			// }

			if (nums[i] == 0) {
				int j = nums[nums.length - 1 - zeroNumber];
				nums[i] = j;
				zeroNumber++;
			}

		}
		for (int j = 0; j < zeroNumber; j++) {
			nums[nums.length - 1 - zeroNumber] = 0;
		}

		return nums;
	}

	/**
	 * 这个解法还是挺精妙的 利用两个临时变量还进行，一个end 记录零出现的位置 、front 记录下一个查找的位置（与for
	 * 循环不同这样做不会出现再次对比）
	 * 
	 * @param nums
	 * @return
	 */
	public static int[] moveZeroesOtherOne(int[] nums) {
		int end = 0;
		int front = 0;
		while (end < nums.length && nums[end] != 0) { // 这里确实找到第一个0位置就移动了
			end++; // find the first position of zero;
		}
		// 找到第一个0之前的数据都是正确的，也要跳过零进行循环
		front = end + 1; // from the position of first zero, to swap the
							// numbers.
		while (front < nums.length) {
			// 找到后面一个不为零的数，进行与零兑换，
			if (nums[front] != 0) { // find the first non-zero number.
				nums[end] = nums[front];
				end++;
				nums[front] = 0;
			}
			front++;
		}
		return nums;
	}

	/**
	 * 这个算法与我的思路其实比较像的 先找出零的数量， 当 == 0 ，零的数量累加 当！=0，将后面的位置移动到前面（要扣除 0 的数量）
	 * 
	 * 零的数量要是大于零，就要将最后面的全部赋值为0
	 * 
	 * @param nums
	 * @return
	 */
	public static void moveZeroesOtherTwo(int[] nums) {
		 if (nums==null) return ;
		int zeroCount = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroCount++;
			} else {
				nums[i - zeroCount] = nums[i];
			}
		}
		while (zeroCount > 0) {
			nums[nums.length - zeroCount--] = 0;
		}

	}

	/**
	 * 快速排序的方法
	 * //break是结束整个循环体，continue是结束单次循环
	 * @param nums
	 */
	public static void moveZeroesOtherThree(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		for (int i = -1, j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {//只处理不等于零的情况
				if (j == ++i)//问题就出在当出现零之后++i 就没有执行到，所以出现零后就要走到continue 下面的语句
					continue;//这句话还如此关键，当没有出现零的情况都返回
				nums[i] = nums[j];//这就将后面零与后面一位数兑换
				nums[j] = 0;
			}
		}
	}

}
