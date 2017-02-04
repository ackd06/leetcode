package zsz.develop;

import org.omg.PortableInterceptor.SUCCESSFUL;

public class ReverseString344 {

	public static void main(String[] args) {
		String reverseString = reverseString("hello");
		System.out.println(reverseString);
	}
	 public static String reverseString(String s) {
	        if(s==null) return "";
	        int length =s.length();
	        StringBuilder stringBuilder = new StringBuilder();
//	        if(length%2 == 0){
	            for(int i = length-1;i>=0;i--){
	            	stringBuilder.append(s.charAt(i));
	            }
//	        }
	        return stringBuilder.toString();
	    }
}
