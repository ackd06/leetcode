package zsz.develop.two;

import java.util.HashMap;

/**
 * 13. Roman to Integer
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Subscribe to see which companies asked this question
 * 
 * 13。罗马整数 给定罗马数字，将其转换为整数。 输入保证范围从1到3999。
 * 
 * @author zhangsz
 *
 */
public class RomanToInteger {

	/**
	 * 预备知识。
	 * 罗马数字是阿拉伯数字传入之前使用的一种数码。罗马数字采用七个罗马字母作数字、即Ⅰ（1）、X（10）、C（100）、M（1000）、V（5）、L（50）、D（500）。记数的方法：
		相同的数字连写，所表示的数等于这些数字相加得到的数，如 Ⅲ=3；
		小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数，如 Ⅷ=8、Ⅻ=12；
		小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9；
		在一个数的上面画一条横线，表示这个数增值 1,000 倍，  =5000。
	 * @param args
	 */
	public static void main(String[] args) {

		int romanToInt = romanToIntOtherOne("III");
		System.out.println(romanToInt);
	}

	
	/**
	 * 错误了
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {
		String[] romans = {"I","X","C","M","V","L","D"};
		int[] romanInts = {1,10,100,1000,5,50,500};
		String[] split = s.split("");
		int total = 0;
		String perStr = "";
		for (int i = 0; i < split.length; i++) {
			if (perStr == ""||split[i].equals(perStr)) {
//				romans.
			}
			 perStr = split[i];
		}
		
		return Integer.parseInt(s);
	}
	
	
	/**
	 * 掌握一个思想。先定义一个空数据，再一个个装进去
	 * 再对空数组做一个循环，判断大小，是该加还是减
	 * @param s
	 * @return
	 */
	 public static int romanToIntOtherOne(String s) {
		    int nums[]=new int[s.length()];
		    for(int i=0;i<s.length();i++){
		        switch (s.charAt(i)){
		            case 'M':
		                nums[i]=1000;
		                break;
		            case 'D':
		                nums[i]=500;
		                break;
		            case 'C':
		                nums[i]=100;
		                break;
		            case 'L':
		                nums[i]=50;
		                break;
		            case 'X' :
		                nums[i]=10;
		                break;
		            case 'V':
		                nums[i]=5;
		                break;
		            case 'I':
		                nums[i]=1;
		                break;
		        }
		    }
		    int sum=0;
		    for(int i=0;i<nums.length-1;i++){// 为了防止数组越界异常，因为比大小的时候nums[i+1]，在最后的时候+1
		        if(nums[i]<nums[i+1])
		            sum-=nums[i];
		        else
		            sum+=nums[i];
		    }
		    return sum+nums[nums.length-1];
		}
	 
	 
	 public static int romanToIntOtherTwo(String s) {
			if (s == null || s.length() == 0)
				return -1;
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			map.put('I', 1);
			map.put('V', 5);
			map.put('X', 10);
			map.put('L', 50);
			map.put('C', 100);
			map.put('D', 500);
			map.put('M', 1000);
			int len = s.length(), result = map.get(s.charAt(len - 1));
			for (int i = len - 2; i >= 0; i--) {
				if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
					result += map.get(s.charAt(i));
				else
					result -= map.get(s.charAt(i));
			}
			return result;
		}

}
