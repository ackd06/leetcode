package zsz.develop;



/**
 * 258. Add Digits  QuestionEditorial Solution  My Submissions
		Difficulty: Easy
		Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
		
		For example:
		
		Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
		
		
		258。添加数字questioneditorial解我的意见
		难度：容易
		给定一个非负整数num，反复添加的所有数字直到结果只有一个数字。
		例如:
		鉴于数= 38，过程是这样的：3 + 8 = 11，1 + 1 = 2。由于2只有一个数字，返回它。
 * @author zhangshengzhong
 *
 */
public class AddDigitsSolution258 {

	
	public static void main(String[] args) {
	int addDigitsMyOne = AddDigitsOtherTwo(29);
	System.err.println("shuzu   S"+addDigitsMyOne);
	}
	
	
	/**
	 * 遇到的第一个问题，怎么知道输入的数字是几位数呢？while (n/10<10) 
	 * 
	 * 
	 * while 循环终止条件  n/10＝＝0
	 * 		这时候也就是当 n小于零的时候
	 * 在分别取出个位和十位相加，
	 * 		当结果为不等于0 的时候继续while
	 * 
	 * @param n
	 * @return
	 */
	public static int AddDigitsMyOne(int n){
		
		while (n/10>0) {
			
			int yushu = n/10;
			int mo = n%10;
			n = yushu +mo;
		}
		
		return n;
		
	}
	
	
	
	/**
	 * 很奇怪的解法
	 * @param num
	 * @return
	 */
	public static int AddDigitsOtherOne(int num){
		 return num==0?0:(num%9==0?9:(num%9));
	}
	
	
	/**
	 * 很奇怪的解法拆解，为什么是这个9？？
	 * 除了他的取值范围可以是0 －8（其中0 的值是9）
	 ＊那么为什么他的反复相加值会等于 ％9 呢？？
	 
	 
	 神奇的推理出现了：num = 10 * a + b = a + b + 9 * a
	 * 
	 * @param num
	 * @return
	 */
	public static int AddDigitsOtherTwo(int num){
		if (num==0) {
			return 0;
		}
		
		if (num%9==0) {
			return 9;
		}else {
			return num%9;
		}
	}
}
