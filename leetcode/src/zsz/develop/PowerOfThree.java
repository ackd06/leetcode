package zsz.develop.two;

/**
 * 326. Power of Three Given an integer, write a function to determine if it is
 * a power of three. Follow up: Could you do it without using any loop /
 * recursion?
 * 
 * 326。功率三 给定一个整数，写一个函数来确定它是否是一个三的幂。 跟进: 你能不使用任何循环/递归吗？
 * 
 * @author zhangsz
 *
 */
public class PowerOfThree {

	// /**
	// * 题目要求不能使用循环和递归，那如果使用时什么情况呢
	// * 先使用循环，超时了
	// * @param n
	// * @return
	// */
	// public boolean isPowerOfThreeMyOne(int n) {
	// if (n == 1) {
	// return true;
	// }
	// int result = 3;
	// while (result <= n) {
	// if (result == n) {
	// return true;
	// }else {
	// result = result*3;
	// }
	// }
	//
	// return false;
	// }

	/**
	 * 感觉智商受到了碾压，不过这是一个通用方法，值得借鉴 借助当前int 型的最大次方的值，如果能整除那肯定也是3的次方
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThreeOtherOne(int n) {
		// 1162261467 is 3^19, 3^20 is bigger than int
		return (n > 0 && 1162261467 % n == 0);
	}

	//
	/**
	 * 使用递归求解
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThreeOtherTwo(int n) {
		return n == 1 || !(n == 0 || n % 3 != 0) && isPowerOfThreeOtherTwo(n / 3);
	}

	/**
	 * 不是很理解
	 * @param n
	 * @return
	 */
	public boolean isPowerOfThreeOtherThree(int n) {
		if (n <= 0)
			return false;
		double a = Math.log10(n) / Math.log10(3); // log power and base 3
		return (a - Math.floor(a)) == 0; // check after the decimal point.
	}

}
