package zsz.develop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 383. Ransom Note Given an arbitrary ransom note string and another string
 * containing letters from all the magazines, write a function that will return
 * true if the ransom note can be constructed from the magazines ; otherwise, it
 * will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * 
 * 383.��� �������������ַ�������������������־���ż���һ���ַ��������д�������ſ��Դ���־�Ϲ�����������true�Ĺ���;������������false��
 * 
 * �ڸ���־���ַ���ÿ����ĸֻ����������ʼ�ʹ��һ�Ρ�
 * 
 * ע�⣺ ����Լ��������ַ���������Сд��ĸ��
 * 
 * @author zhangsz
 *
 */
public class RansomNote383 {
	
/**
 * ������뷨�ʹ���(�����Ǵ�ҲҪ֪�����ԭ�򣡣�����)
 * �ҵ��뷨û������������
 * ����Ч�ʿ����е�����
 * �ⷨ˼·���Ƚ���־���ַ��������ڽ�����ӵ�list�����У���һ���ͺ������ˣ������������������򣬵�ɾ��Ҫ��list ��ɾ����
 * 		���ö��ֲ��ң��ҵ�һ��ɾ��һ����û�ҵ���˵��������
 * 		
 * @param ransomNote
 * @param magazine
 * @return
 */
	List<Character> list;
	public  boolean canConstructMyOne(String ransomNote, String magazine) {
		if (ransomNote.length() == 0&&magazine.length() == 0) {
			return true;
		}
		if (magazine.length() == 0) {
			return false;
		}
//		HashSet<Character> set = new HashSet<>();
		char[] cs = magazine.toCharArray();
		Arrays.sort(cs);//
		list = new ArrayList<>(); 
		for(int j = 0;j < magazine.length();j++){
			list.add(cs[j]);
		}
		
		for(int i = 0;i<ransomNote.length();i++){
			
			char target = ransomNote.charAt(i);
			boolean isSearch = binarySearch(list,target);
			if (!isSearch) {
				return false;
			}
			
		}
		
		
		return true;
	}
	
	private  boolean binarySearch(List<Character> list, char target){
		int low = 0;
		int high = list.size()-1;
		while (low<=high) {
			int mid = low +(high - low)/2;
			if (list.get(mid) == target) {
				list.remove(mid);
				return true;
			}else if  (list.get(mid)<target) {
				low = mid+1;
			}else if (list.get(mid) > target) {
				high = mid -1;
			}
			
		}
		
		return false;
	}
	
	
//	==============================Other start=========================================
	/**
	 * ���� string.indexof() ���㷨
	 * 		int indexOf(int ch)  						 ����ָ���ַ��ڴ��ַ����е�һ�γ��ִ��������� 
			int indexOf(int ch, int fromIndex) 			��ָ����������ʼ�����������ڴ��ַ����е�һ�γ���ָ���ַ����������� 
			int indexOf(String str) 					���ص�һ�γ��ֵ�ָ�����ַ����ڴ��ַ����е������� 
			int indexOf(String str, int fromIndex) 		��ָ������������ʼ�����ص�һ�γ��ֵ�ָ�����ַ����ڴ�
	 * 		((index = magazine.indexOf(notes[i])) < 0) ��һ�γ��ֵ�λ�ö�С��0 �Ļ������϶���Ϊfalse
	 * 
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	 public boolean canConstructOtherOne(String ransomNote, String magazine) {
	        char[] notes = ransomNote.toCharArray();
	        int index;
	        for (int i = 0; i < notes.length; i++) {
	            if (notes[i] == '.')
	                continue;
	            else if ((index = magazine.indexOf(notes[i])) < 0)
	                return false;
	            else {
	                int j = i;//����һ����ʱ����,���������һ�β��ҵ�λ�ã���һ��������j ��ʼ����
	                while ((j = ransomNote.indexOf(notes[i], j + 1)) >= 0) {
	                    if ((index = magazine.indexOf(notes[i], index + 1)) < 0)
	                        return false;
	                    notes[j] = '.';//�鵽�ɹ���ͽ�����ֵΪ'.'
	                }
	            }
	        }
	        return true;
	    }
	 
	 
	 /**
	  * 
	  * ʾ��Map.getOrDefault��������JDK8֮ǰ��ʵ�ַ������Աȡ�JDK8
//	  * ��������Map.getOrDefault��������ڴ�ͳ��ʵ�ַ��������õĴ�����������
//	  * ����������һ��final���͵ı��������շ���ֵ�� 
	  * // JDK8֮ǰ��ʵ�ַ���
		//	 String capitalGeorgia = statesAndCapitals.get("Georgia");
		//	 if (capitalGeorgia == null)
		//	 {
		//	    capitalGeorgia = "Unknown";
		//	 }
		 *  // JDK8��ʵ�ַ���
//	 final String capitalWisconsin = statesAndCapitals.getOrDefault("Wisconsin", "Unknown");
	  * 
	  * ����map �����ԣ�key ��Զ���䣬��value ����һ����Ӽ�
	  * 	�Ƚ���־�е�������ӽ�map �У�����ͬ�ľͲ����ۼ�
	  * ��ȡ���������е�ÿ���ַ�������ȥmap ��ȡ���ۼ�
	  * ����С��0 ��ʧ����
	  *  �ǵ�ÿ�ζ�Ҫ����map
	  * @param ransomNote
	  * @param magazine
	  * @return
	  */
	 public boolean canConstructOtherTwo(String ransomNote, String magazine) {
	        Map<Character, Integer> magM = new HashMap<>();
	        for (char c:magazine.toCharArray()){
	            int newCount = magM.getOrDefault(c, 0)+1;
	            magM.put(c, newCount);
	        }
	        for (char c:ransomNote.toCharArray()){
	            int newCount = magM.getOrDefault(c,0)-1;
	            if (newCount<0)
	                return false;
	            magM.put(c, newCount);
	        }
	        return true;
	    }
	 
	/**
	 * cnt[c-'a'] ��abcde ���±�� 0 ��ʼ
	 * cnt[c-'a']++ ��ÿ���ҵ�һ���Ͷ�������һ���ۼ�
	 * �ٴ���־��ȡ��ֵ������0 �Ͳ��ɹ�
	 * ���ؼ���һ�㣡������  if(--cnt[c-'a']<0)
	 * ����ж��ֵ����ô����Ҫ���� ÿ�μ�1
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	 public boolean canConstructOtherThree(String ransomNote, String magazine) {
	        int[] cnt = new int[26];
	        for(char c: magazine.toCharArray()){
	            cnt[c-'a']++;
	        }
	        
	        for(char c: ransomNote.toCharArray()){
	            if(--cnt[c-'a']<0)
	                return false;
	        }
	        return true;
	    }
	 
	 
	 /**
	  * ��ߵ��߼��ͱȽ�����һ��
	  * ����ӽ� array ����־���ַ��ۼӣ�������ۼ�
	  * �����һ��С��0 ��ʱ����ô�϶�����ƥ�䲻�ɹ���
	  * 
	  * @param ransomNote
	  * @param magazine
	  * @return
	  */
	  public boolean canConstructOtherFour(String ransomNote, String magazine) {
	        int[] freq = new int[26];
	        
	        for(int i=0; i<magazine.length(); i++){
	            freq[magazine.charAt(i)-'a'] ++;
	        }
	        for(int i=0; i<ransomNote.length(); i++){
	            freq[ransomNote.charAt(i)-'a'] --;
	        }
	        
	        for(int i=0; i<26; i++){
	            if(freq[i] < 0){
	                return false;
	            }
	        }
	        
	        return true;
	    }
	
	
//	==============================Other end=========================================
}
