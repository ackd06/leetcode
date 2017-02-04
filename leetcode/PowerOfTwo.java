package zsz.develop;
/**
 * ������������ж�һ�����Ƿ�Ϊ2�Ĵη���
 * 231. Power of Two 
		Given an integer, write a function to determine if it is a power of two.
 * @author zhangsz
 *
 */
public class PowerOfTwo {
	/**
	 *�������ʱ��С�Ŀ����ˣ�λ����
	 *������һ�£����Ϊ2 �Ĵη�����ô��һ��ֻ��һλ��Ϊ1�����򶼲�Ϊ����ƽ����
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
	   * �������֪ʶ
	   * 
	   * 	һ�� ��& 			 ������������λ��Ϊ1�������Ϊ1��������Ϊ0
	   * 	���������Ķ����Ʊ�ʾ����
				������һ�� int ���͵�����ֵΪ3����ô������֪�����ڼ�����б�ʾΪ��
				
				00000000 00000000 00000000 00000011
				
				��Ϊint���͵���ռ��4�ֽڣ�32λ��������ǰ������һ��0��
				
				�ڼ�����У�����������ֵ�Ĳ�����ʽ��
				
				ʲô�в����أ�����ȴ�ԭ�룬����˵��
				
				ԭ�룺һ�����������վ���ֵ��Сת���ɵĶ�����������Ϊԭ�롣
				
				���� 00000000 00000000 00000000 00000011 �� 3�� ԭ�롣
				
				���룺������������λȡ�������õ��¶���������Ϊԭ���������ķ��롣
				
				ȡ������ָ��1��0��0��1
				
				���磺00000000 00000000 00000000 00000011�ķ�����11111111 11111111 11111111 11111100����
				
				���룺�����1��Ϊ���롣
				
				ֻ����ֻ��һλ����ʱ������& ����������ȵ�
				
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
	   * ֻҪ������ Integer.MAX_VALUE+1;
	   * @param n
	   * @return
	   */
	  public boolean isPowerOfTwoOtherTwo(int n) {
	        long k=Integer.MAX_VALUE+1;
	        return n>0&&k%n==0;
	    }
	  
	  
	  /**
	   * �ݹ����
	   * ���� Ϊ1 ��ʱ�� ��Ϊ��
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
