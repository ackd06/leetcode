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
 * 383.赎金 给定任意勒索字符串，包含来自所有杂志的信件另一个字符串，如果写的勒索信可以从杂志上构建，将返回true的功能;否则，它将返回false。
 * 
 * 在该杂志的字符串每个字母只能在你的赎金笔记使用一次。
 * 
 * 注意： 你可以假设两个字符串仅包含小写字母。
 * 
 * @author zhangsz
 *
 */
public class RansomNote383 {
	
/**
 * 最初的想法就错了(就算是错也要知道错的原因！！！！)
 * 我的想法没错！！！！！、
 * 但是效率可能有点问题
 * 解法思路：先将杂志的字符串排序，在将他添加到list集合中（这一步就很尴尬了，排序在数组里面排序，但删除要在list 中删除）
 * 		利用二分查找，找到一个删除一个，没找到就说明赎金错误
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
	 * 利用 string.indexof() 的算法
	 * 		int indexOf(int ch)  						 返回指定字符在此字符串中第一次出现处的索引。 
			int indexOf(int ch, int fromIndex) 			从指定的索引开始搜索，返回在此字符串中第一次出现指定字符处的索引。 
			int indexOf(String str) 					返回第一次出现的指定子字符串在此字符串中的索引。 
			int indexOf(String str, int fromIndex) 		从指定的索引处开始，返回第一次出现的指定子字符串在此
	 * 		((index = magazine.indexOf(notes[i])) < 0) 第一次出现的位置都小于0 的话。。肯定就为false
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
	                int j = i;//定义一个临时变量,用来标记下一次查找的位置，下一次索引从j 开始查找
	                while ((j = ransomNote.indexOf(notes[i], j + 1)) >= 0) {
	                    if ((index = magazine.indexOf(notes[i], index + 1)) < 0)
	                        return false;
	                    notes[j] = '.';//查到成功后就将他赋值为'.'
	                }
	            }
	        }
	        return true;
	    }
	 
	 
	 /**
	  * 
	  * 示范Map.getOrDefault方法并和JDK8之前的实现方法做对比。JDK8
//	  * 中新增的Map.getOrDefault方法相比于传统的实现方法，所用的代码行数更少
//	  * 并且允许用一个final类型的变量来接收返回值。 
	  * // JDK8之前的实现方法
		//	 String capitalGeorgia = statesAndCapitals.get("Georgia");
		//	 if (capitalGeorgia == null)
		//	 {
		//	    capitalGeorgia = "Unknown";
		//	 }
		 *  // JDK8的实现方法
//	 final String capitalWisconsin = statesAndCapitals.getOrDefault("Wisconsin", "Unknown");
	  * 
	  * 利用map 的特性，key 永远不变，对value 进行一个相加减
	  * 	先将杂志中的数据添加进map 中，有相同的就不断累加
	  * 在取出勒索信中的每个字符，不断去map 中取，累减
	  * 减到小于0 就失败了
	  *  记得每次都要更新map
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
	 * cnt[c-'a'] 让abcde 的下标从 0 开始
	 * cnt[c-'a']++ ，每次找到一个就对他进行一个累加
	 * 再从杂志中取出值，等于0 就不成功
	 * 但关键的一点！！！！  if(--cnt[c-'a']<0)
	 * 如果有多个值，那么就需要给他 每次减1
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
	  * 这边的逻辑就比较清晰一点
	  * 都添加进 array ，杂志的字符累加，赎金信累减
	  * 最后有一个小于0 的时候，那么肯定就是匹配不成功了
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
