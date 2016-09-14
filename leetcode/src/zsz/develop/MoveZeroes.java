package zsz.develop;


/**
 *  Move Zeroes
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

	For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
	
	Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
	
	
	����һ����������飬дһ������������0�Ľ������ڱ��ַ���Ԫ�ص����˳��
	���磬��������= [ 0��1��0��3��12 ]��������Ĺ��ܺ���Ӧ��[ 1��3��12��0��0 ]��
	ע��
	�������������������һ������ĸ�����
	�������ٲ�����������
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
	 * �ⷨ˼·���Ǵ���
	 * 
	 * @param nums
	 * @return
	 */
	public static int[] moveZeroes(int[] nums) {
		int zeroPosition = 0;
		int zeroNumber = 0;
		for (int i = 0; i < nums.length; i++) {
			// if (nums[i] == 0){
			// // ����ǽ�Ϊ���ĩ�ת�Ƶ����λ��
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
	 * ����ⷨ����ͦ����� ����������ʱ���������У�һ��end ��¼����ֵ�λ�� ��front ��¼��һ�����ҵ�λ�ã���for
	 * ѭ����ͬ��������������ٴζԱȣ�
	 * 
	 * @param nums
	 * @return
	 */
	public static int[] moveZeroesOtherOne(int[] nums) {
		int end = 0;
		int front = 0;
		while (end < nums.length && nums[end] != 0) { // ����ȷʵ�ҵ���һ��0λ�þ��ƶ���
			end++; // find the first position of zero;
		}
		// �ҵ���һ��0֮ǰ�����ݶ�����ȷ�ģ�ҲҪ���������ѭ��
		front = end + 1; // from the position of first zero, to swap the
							// numbers.
		while (front < nums.length) {
			// �ҵ�����һ����Ϊ���������������һ���
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
	 * ����㷨���ҵ�˼·��ʵ�Ƚ���� ���ҳ���������� �� == 0 ����������ۼ� ����=0���������λ���ƶ���ǰ�棨Ҫ�۳� 0 ��������
	 * 
	 * �������Ҫ�Ǵ����㣬��Ҫ��������ȫ����ֵΪ0
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
	 * ��������ķ���
	 * //break�ǽ�������ѭ���壬continue�ǽ�������ѭ��
	 * @param nums
	 */
	public static void moveZeroesOtherThree(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		for (int i = -1, j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {//ֻ��������������
				if (j == ++i)//����ͳ��ڵ�������֮��++i ��û��ִ�е������Գ�������Ҫ�ߵ�continue ��������
					continue;//��仰����˹ؼ�����û�г���������������
				nums[i] = nums[j];//��ͽ������������һλ���һ�
				nums[j] = 0;
			}
		}
	}

}
