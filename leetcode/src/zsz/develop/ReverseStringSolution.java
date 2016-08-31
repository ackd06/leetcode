package zsz.develop;

public class ReverseStringSolution {

	/**
	 * 我的第一种解法
	 * 
	 * @param s
	 * @return
	 */
	public String reverseStringMyOne(String s) {
		if (s == null)
			return "";
		int length = s.length();
		StringBuilder stringBuilder = new StringBuilder();
		// if(length%2 == 0){
		for (int i = length - 1; i >= 0; i--) {
			stringBuilder.append(s.charAt(i));
		}
		// }
		return stringBuilder.toString();
	}

	/***
	 * 参考别的一种，利用系统api来快速实现
	 * @param s
	 * @return
	 */
	public String reverseStringOtherOne(String s) {
		StringBuilder str = new StringBuilder(s);
		return str.reverse().toString();
	}
	
	
	/***
	 * 参考别人第二种，隶属char【】
	 * @param s
	 * @return
	 */
	public String reverseStringOtherTwo(String s) {

		int length = s.length();
		char[] cs = new char[length];
		for(int i=0;i<length;i++){
			cs[i] = s.charAt(length-1-i);
		}
		// 不能直接char【】 。tostring 打印出的是string地址
		return new String(cs);
	}
	/***
	 * 参考别人第三种，交换
	 * @param s
	 * @return
	 */
	public String reverseStringOtherThere(String s) {
		
		 int i=0,j=s.length()-1;
	        char[] str=s.toCharArray();
	        while(i<j){
	           char temp=str[i];
	           str[i]=str[j];
	           str[j]=temp;
	            i++;
	            j--;
	        }
	        String ss=new String(str);
	        return ss;
	}
}
