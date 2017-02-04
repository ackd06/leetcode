package zsz.develop.two;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number  
		Write an algorithm to determine if a number is "happy".
		
		A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
		
		Example: 19 is a happy number
		
		1*1 + 9*9 = 82
		8*8 + 2*2 = 68
		6*6 + 8*8 = 100
		1*1 + 0*0 + 0*0 = 1
		
		202。快乐的数
		写一个算法来确定一个数字是否是“快乐”。
		一个快乐数是一个由以下过程定义的数字：从任何正整数开始，用它的数字的平方的总和取代数字，并重复这个过程，直到数字等于1（它将停留），或它循环在一个周期不包括1。这个过程在1结束的那些数字是快乐的数字。
		例子：19是一个快乐的数字
		1*1 + 9*9 = 82
		8*8 + 2*2 = 68
		6*6 + 8*8 = 100
		1*1 + 0*0 + 0*0 = 1
		
 * @author zhangsz
 *
 */
public class HappyNumber {

	/**
	 * 看题目的样子感觉就用递归实现
	 * 笨方法思路对了，但是并不知道递归基，没想明白
	 * @param n
	 * @return
	 */
//	 public boolean isHappyMyOne(int n) {
//		
////		 if (n<10) {
////			return n == 1;
////		}
//		 int result = 0;
////		 int m = n/10;
//		 while (n>=10) {
//			 
//			int r = n%10;
//			result += r*r;
//			n = n/10;
//		}
//		
//		result += n*n;
//		
//		 return isHappyMyOne(result);
//	    }
	 
	 /**
	  * 递归基 
	  *  if( n == 0 ){
	            return false;
	        }
	        while( n != 1 && n != 4 ){
	            n = sumOfSquares(n);
	        }
	  * @param n
	  * @return
	  */
	 public boolean isHappyOtherOne(int n) {
	        if( n == 0 ){
	            return false;
	        }
	        while( n != 1 && n != 4 ){
	            n = sumOfSquares(n);
	        }
	        return (n == 1) ? true : false;
	    }
	    public int sumOfSquares(int n){
	        int val = 0;
	        while( n > 0 ){
	            int tempMul = n % 10;
	            val += (tempMul * tempMul);
	            n = n / 10;
	        }
	        return val;
	    }
	    
	    /**
	     * 使用hashset 的解法
	     * 刚才一直不明白为什么是4 的递归基，这里的解法就是，单出现循环后肯定就不会再是快乐数了
	     * @param n
	     * @return
	     */
	    public boolean isHappyOtherTwo(int n) {
	        if(n <= 0) {
	            return false;
	        }
	        /*set result to input number, if n > 1, go into the while loop*/
	        int res = n;
	        /* >1 number will appear in loop, use HashSet to find repetitive sum of square digits*/
	        Set<Integer> set = new HashSet<Integer>();
	        /*The loop ends when res = 1 or when repetitive number appear*/
	        while (res > 1){
	            if(!set.add(res)){
	                return false;
	            }
	            set.add(res);
	            res = SquareOfDigits (res);
	        }
	        return true;
	    }
	    /*The following method add up the square of digits of input number*/
	    private int SquareOfDigits (int n) {
	        int sum = 0;
	        while (n > 0){
	            sum = sum + (int) Math.pow(n%10, 2);
	            System.out.println("digit: " + n % 10);
	            n = n/10;            
	        }
	        System.out.println("Sum: "+ sum);
	        return sum;
	    }
}
