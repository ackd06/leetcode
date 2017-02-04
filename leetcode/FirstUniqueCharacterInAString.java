package zsz.develop;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

//	public static void main(String[] args) {
//		
//
//	}
	
//	/**
//	 * Ҫ�ҵ��ǵ�һ�����ظ���Ԫ��
//	 * @param s
//	 * @return
//	 */
//	  public int firstUniqChar(String s) {
////	        HashSet<Character> set = new HashSet<>();
//	        char[] charArray = s.toCharArray();
//	        Arrays.sort(charArray);
//	        for(int i = 0;i<charArray.length;i++){
////	        	if (!set.add(charArray[i])) {
////					return i;
////				}
//	        	char c = charArray[i];
//	        	int binarySearch = binarySearch(charArray,c );
//	        }
//	        
//		  
//		  return -1;
//	    }
//	  public int binarySearch(char[] nums,Character target){
//		  int low = 0;
//		  int high = nums.length-1;
//		  while (low<high) {
//			  int mid = low +(high-low)/2;
//			  if (nums[mid] == target) {
//				return mid;
//			}else if (nums[mid]<=target) {
//				high = mid-1;
//			}else if (nums[mid]>=target){
//				low = mid +1;
//			}
//			
//		}
//		  
//		  return -1;
//	  }
	
	
	/**
	 * ͦ����˼�Ľⷨ����û����
	 * ���õ�һ�γ��ֵ�ʱ����� hashmap���Ժ��ٳ��־ͽ� ǰһ��hashmap �е�����ȡ�� ��ӵ� repeated�����У�������Ϊtrue 
	 * ������ȡ����repeated �е�һ��Ϊfalse ��Ԫ�ر�Ϊ ��һ����һ�γ��ֵ�Ԫ��
	 * @param s
	 * @return
	 */
	 public int firstUniqCharOtherOne(String s) {

	        int strLen = s.length();
	    
	        HashMap<Character, Integer> firstIndex = new HashMap<>();
	        boolean[] repeated = new boolean[strLen];//
	    
	        for (int index = 0; index < strLen; index++) {
	            char ch = s.charAt(index);
	            //��һ����ͦ����ģ���ȡ�����ж��Ƿ�Ϊ��
	            // Ϊ������ӽ�ȥ
	            Integer firstAppeared = firstIndex.get(ch);
	            if (null == firstAppeared) {//������ǵ�һ��ʹ���е�λ��
	                firstIndex.put(ch, index);
	            } else {//����ͬʱ�õ��˲����Ե�
	                repeated[firstAppeared] = true;
	                repeated[index] = true;
	            }
	        }

	        // find the first uniqueChar's index�ҵ���һ��û�г��ֵ�
	        for (int index = 0; index < strLen; index++) {
	            if (!repeated[index]) {
	                return index;
	            }
	        }
	        return -1;
	    }

	 
	 /**
	  * �������кܶ�api ������Ϥ��
	  * HashMap.containsKey��key��- �÷����ж�Map���϶������Ƿ����ָ���ļ���
	  * ����ҵ��Ѿ�������key ��ô��ʧ�ܣ���������Ϊ���鳤�ȣ�int��
	  * ������ӽ�ȥ
	  * ȡ��hashmap �е�ֵ�����Ϊ����ĳ�����ô�ͷ���ʧ��-1
	  * @param s
	  * @return
	  */
	 public int firstUniqCharOtherTwo(String s) {
			Map<Character, Integer> charIndex = new HashMap<>();
			// 1st pass: map and check duplicate
			for (int i = 0; i < s.length(); i++)
				if (charIndex.containsKey(s.charAt(i))) // visited; invalidate it
					charIndex.put(s.charAt(i), s.length()); // invalidate;
				else
					charIndex.put(s.charAt(i), i);

			// 2nd pass: get index
			int result = s.length(); // invalid
			for (int index : charIndex.values())
				result = Math.min(result, index); // 'first'=>'min index'=>'min'
			return result == s.length() ? -1 : result;
		}
	 
	 
	 /**
	  * ����ⷨ��˼���Ѿ�������ֹһ���ˣ�Ҫ������
	  * ���Ҫ�Ƚ�   �ַ�   ����ô�� ����һ������Ϊ26 ��array 
	  * ÿ����һ����++
	  * ȡ����ʱ���������1����ô�ͷ��أ�û��Ϊ1 �ľͷ���-1
	  * 
	  * 
	  * ֮ǰһֱ��������㷨���ᰴ˳�򷵻أ�����ʵ����һ��ѭ��Ҳ�ǰ�˳��ȡ�ã�����û�д����������
	  * @param s
	  * 
	  * @return
	  */
	 public static int firstUniqCharOtherThree(String s) {
	        int freq [] = new int[26];
	        for(int i = 0; i < s.length(); i ++)
	            freq [s.charAt(i) - 'a'] ++;
	        for(int i = 0; i < s.length(); i ++)
	            if(freq [s.charAt(i) - 'a'] == 1)
	                return i;
	        return -1;
	    }
	 
	 
	 /**
	  * �⡣��������ѧ������api
	  * ��һ�κ����һ�γ��ֵ�λ����ͬ����Ϊͬһ��
	  * @param s
	  * @return
	  */
	 public static int firstUniqChar(String s) {
	        
			char[] a = s.toCharArray();
			
			for(int i=0; i<a.length;i++){
				if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
			}
			return -1;
	    }
}
