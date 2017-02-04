package zsz.develop;

public class ReverseStringSolution {

	/**
	 * �ҵĵ�һ�ֽⷨ
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
	 * �ο����һ�֣�����ϵͳapi������ʵ��
	 * @param s
	 * @return
	 */
	public String reverseStringOtherOne(String s) {
		StringBuilder str = new StringBuilder(s);
		return str.reverse().toString();
	}
	
	
	/***
	 * �ο����˵ڶ��֣�����char����
	 * @param s
	 * @return
	 */
	public String reverseStringOtherTwo(String s) {

		int length = s.length();
		char[] cs = new char[length];
		for(int i=0;i<length;i++){
			cs[i] = s.charAt(length-1-i);
		}
		// ����ֱ��char���� ��tostring ��ӡ������string��ַ
		return new String(cs);
	}
	/***
	 * �ο����˵����֣�����
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
