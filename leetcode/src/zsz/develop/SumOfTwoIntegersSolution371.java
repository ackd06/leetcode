package zsz.develop;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 * 
 * ��������������B�ĺͣ����㲻����ʹ�������+�͡��� ����: ����a = 1��B = 2������3��
 * 
 * @author zhangsz
 *
 */
public class SumOfTwoIntegersSolution371 {

	/**
	 * ���ⲻ�ᣬ1��int תbinary
	 * 		  2.����binary �����Ӽ�
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
	 * �ǳ������һ���ⷨ
	 * 	λ�������֪ʶ��
	 * 	 ��& 			 ������������λ��Ϊ1�������Ϊ1��������Ϊ0
	 * 	�� | 			 ����λֻҪ��һ��Ϊ1����ô�������1�������Ϊ0����
	 * 	�� ~  		���λΪ0�������1�����λΪ1�������0
	 * ��������^		������������λ�У���ͬ����Ϊ0����ͬ����Ϊ1��
	 * 	 
	 * λ�������
	 * 
		<<      :     �����������num << 1,�൱��num����2

		>>      :     �����������num >> 1,�൱��num����2

		u>>>    :     �޷������ƣ����Է���λ����λ����0����
		
		�ο���ԭ�����ӣ�https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation/2
		
		
		���üӜp����λԪ���\�㣬�䌍��Ҳ������������ֱ�ӻ؂�a+b߀�Ǖ�ͨ�^�ģ�����㱻�@�}��ס�����h�����^�����μ��W������
	���Oݔ��Ĕ��֞�a=3(0011), b=9(1001)
��Ӳ����]�Mλ a = a^b = (0011)^(1001) = 1010
���ֻ���]�Mλ carry =a&b = (0011)^(1001) = 0001 �Mλֵ
b = 0001 << 1 = 0010 �Mλ
��һ݆�� a= 10(1010), b = 2(0010)
��Ӳ����]�Mλ a = a^b = (1010)^(0010) = 1000
���ֻ���]�Mλ carry =a&b = (1010)^(0010) = 0010 �Mλֵ
b = 0001 << 1 = 0100 �Mλ
�ڶ�݆�� a= 8(1000), b = 4(0010)
��Ӳ����]�Mλ a = a^b = (1000)^(0100) = 1100
���ֻ���]�Mλ carry =a&b = (1010)^(0010) = 0000 �Mλֵ
b = 0000 << 1 = 0
b=0�������ɣ� a = 1100 = 12
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
	 * ����Ŀһ�������õ���һ��λ���㣬��Ϊ�������裺 
		1������ a��b 
		2������λ��ab��ӣ������ǽ�λ������� a xor b����1+1 =0 0+0 = 0 1+0=1����λ���뿴���� 
		3������ab�Ľ�λ�Ļ���ֻ�ж���ͬΪ1�Ž�λ����˽�λ���Ա�ʾΪ (a and b) << 1 ��ע����Ϊ�ǽ�λ��������Ҫ�����ƶ�1λ 
		4������a+b���Կ��� ��a xor b��+ ��(a and b) << 1������ʱ����� (a and b) << 1 ��Ϊ0���͵ݹ���������ʽ�ɣ���Ϊ��a xor b��+ ��(a and b) << 1�� Ҳ�п��ܽ�λ������������Ҫ���ϵĴ����λ��
		
		
		
	 * @param a
	 * @param b
	 * @return
	 */
	 public static int getSumOtherTwo(int a, int b) {
	        int result = a ^ b; // ��λ��
	        int carray = (a & b) << 1; // �����λ
	        if(carray!=0) 
	        	return  getSumOtherTwo(result,carray); //�жϽ�λ�봦��
	        return result;
	    }
//	====================start=======================================
//	====================ͬʱ�������������ֽⷨ��ҪϸϸƷζ=======================================
	
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
