package zsz.develop;
/**
 * 这道题让我们判断一个数是否为2的次方数
 * 231. Power of Two 
		Given an integer, write a function to determine if it is a power of two.
 * @author zhangsz
 *
 */
public class PowerOfTwo {
	/**
	 *看翻译的时候不小心看到了，位运算
	 *回忆了一下，如果为2 的次方数那么他一定只有一位数为1，否则都不为他的平方数
	 *
	 * @param n
	 * @return
	 */
//	  public boolean isPowerOfTwo(int n) {
////		  int result = n;
//		  boolean b = false;
//		  while (n>0) {
//			  if (n%2 == 0) {
//				n = n/2;
//			  }else {
//				  if (b) {
//					return false;
//				}
//				b = true;
//			}
//			  
//			
//		}
//		 
//	
//	        
//		  return  b;
//	    }
	  
	  /**
	   * 解题基本知识
	   * 
	   * 	一： 与& 			 两个操作数中位都为1，结果才为1，否则结果为0
	   * 	二：负数的二进制表示方法
				假设有一个 int 类型的数，值为3，那么，我们知道它在计算机中表示为：
				
				00000000 00000000 00000000 00000011
				
				因为int类型的数占用4字节（32位），所以前面填了一堆0。
				
				在计算机中，负数以其正值的补码形式表达。
				
				什么叫补码呢？这得先从原码，反码说起。
				
				原码：一个整数，按照绝对值大小转换成的二进制数，称为原码。
				
				比如 00000000 00000000 00000000 00000011 是 3的 原码。
				
				反码：将二进制数按位取反，所得的新二进制数称为原二进制数的反码。
				
				取反操作指：1变0；0变1
				
				比如：00000000 00000000 00000000 00000011的反码是11111111 11111111 11111111 11111100。　
				
				补码：反码加1称为补码。
				
				只有在只有一位数的时候，他们& 出来才是相等的
				
	   * @param n
	   * @return
	   */
	  public boolean isPowerOfTwoOtherOne(int n) {
	    	/**
	    	 * 3: 0011, -4: 1100, -3: 1101
	    	 * 6: 0110, -7: 1001, -6: 1010
	    	 * num & -num: least significant non-zero digit
	    	 */
	        return n > 0 && n == (n & -n);
	    }
	  
	  
	  /**
	   * 只要能整除 Integer.MAX_VALUE+1;
	   * @param n
	   * @return
	   */
	  public boolean isPowerOfTwoOtherTwo(int n) {
	        long k=Integer.MAX_VALUE+1;
	        return n>0&&k%n==0;
	    }
	  
	  
	  /**
	   * 递归调用
	   * 余数 为1 的时候 才为真
	   * 
	   * @param n
	   * @return
	   */
	  public boolean isPowerOfTwo(int n) {
		    
		    if(n==1) return true ; 
		    else if ( n%2==1 || n==0 ) return false ;
		    
		    return isPowerOfTwo(n/2);
		    
		}
	
}
