package zsz.develop;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 * 
 * 计算两个整数和B的和，但你不允许使用运算符+和—。 例子: 给定a = 1和B = 2，返回3。
 * 
 * @author zhangsz
 *
 */
public class SumOfTwoIntegersSolution371 {

	/**
	 * 这题不会，1：int 转binary
	 * 		  2.两个binary 如何相加减
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSumMyOne(int a, int b) {
		String aBin = Integer.toBinaryString(a);
		String bBin = Integer.toBinaryString(b);
		
		
		
		return 0;
	}
	
	
	/**
	 * 非常神奇的一个解法
	 * 	位运算基础知识：
	 * 	 与& 			 两个操作数中位都为1，结果才为1，否则结果为0
	 * 	或 | 			 两个位只要有一个为1，那么结果就是1，否则就为0，、
	 * 	非 ~  		如果位为0，结果是1，如果位为1，结果是0
	 * 异或运算符^		两个操作数的位中，相同则结果为0，不同则结果为1。
	 * 	 
	 * 位移运算符
	 * 
		<<      :     左移运算符，num << 1,相当于num乘以2

		>>      :     右移运算符，num >> 1,相当于num除以2

		u>>>    :     无符号右移，忽略符号位，空位都以0补齐
		
		参考的原文链接，https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation/2
		
		
		不用加減改用位元做運算，其實我也不會阿，而且直接回傳a+b還是會通過的，如果你被這題卡住，建議先跳過。以下單純學習分享。
	假設輸入的數字為a=3(0011), b=9(1001)
相加不考慮進位 a = a^b = (0011)^(1001) = 1010
相加只考慮進位 carry =a&b = (0011)^(1001) = 0001 進位值
b = 0001 << 1 = 0010 進位
第一輪後 a= 10(1010), b = 2(0010)
相加不考慮進位 a = a^b = (1010)^(0010) = 1000
相加只考慮進位 carry =a&b = (1010)^(0010) = 0010 進位值
b = 0001 << 1 = 0100 進位
第二輪後 a= 8(1000), b = 4(0010)
相加不考慮進位 a = a^b = (1000)^(0100) = 1100
相加只考慮進位 carry =a&b = (1010)^(0010) = 0000 進位值
b = 0000 << 1 = 0
b=0，相加完成， a = 1100 = 12
 	 * @param a
	 * @param b
	 * @return
	 */
	public  int getSumOtherOne(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}
	
	
	/**
	 * 和题目一样，我用的是一个位运算，分为两个步骤： 
		1、输入 a，b 
		2、按照位把ab相加，不考虑进位，结果是 a xor b，即1+1 =0 0+0 = 0 1+0=1，进位的请看下面 
		3、计算ab的进位的话，只有二者同为1才进位，因此进位可以标示为 (a and b) << 1 ，注意因为是进位，所以需要向左移动1位 
		4、于是a+b可以看成 （a xor b）+ （(a and b) << 1），这时候如果 (a and b) << 1 不为0，就递归调用这个方式吧，因为（a xor b）+ （(a and b) << 1） 也有可能进位，所以我们需要不断的处理进位。
		
		
		
	 * @param a
	 * @param b
	 * @return
	 */
	 public static int getSumOtherTwo(int a, int b) {
	        int result = a ^ b; // 按位加
	        int carray = (a & b) << 1; // 计算进位
	        if(carray!=0) 
	        	return  getSumOtherTwo(result,carray); //判断进位与处理
	        return result;
	    }
//	====================start=======================================
//	====================同时给出了其他几种解法需要细细品味=======================================
	
	// Iterative
	public int getSubtract01(int a, int b) {
		while (b != 0) {
			int borrow = (~a) & b;
			a = a ^ b;
			b = borrow << 1;
		}
		
		return a;
	}

	// Recursive
	public int getSum(int a, int b) {
		return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
	}

	// Recursive
	public int getSubtract(int a, int b) {
		return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
	}

	// Get negative number
	public int negate(int x) {
		return ~x + 1;
	}
	
//	=====================end======================================
}
