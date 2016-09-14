package zsz.develop;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

//	public static void main(String[] args) {
//		
//
//	}
	
//	/**
//	 * 要找的是第一个非重复的元素
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
	 * 挺有意思的解法，还没做过
	 * 利用第一次出现的时候加入 hashmap，以后再出现就将 前一次hashmap 中的数据取出 添加到 repeated数组中，并都设为true 
	 * 当我们取出第repeated 中第一个为false 的元素变为 第一个第一次出现的元素
	 * @param s
	 * @return
	 */
	 public int firstUniqCharOtherOne(String s) {

	        int strLen = s.length();
	    
	        HashMap<Character, Integer> firstIndex = new HashMap<>();
	        boolean[] repeated = new boolean[strLen];//
	    
	        for (int index = 0; index < strLen; index++) {
	            char ch = s.charAt(index);
	            //这一步就挺精妙的，先取出来判断是否为空
	            // 为空则添加进去
	            Integer firstAppeared = firstIndex.get(ch);
	            if (null == firstAppeared) {//插入的是第一次使用有的位置
	                firstIndex.put(ch, index);
	            } else {//这里同时得到了不可以的
	                repeated[firstAppeared] = true;
	                repeated[index] = true;
	            }
	        }

	        // find the first uniqueChar's index找到第一个没有出现的
	        for (int index = 0; index < strLen; index++) {
	            if (!repeated[index]) {
	                return index;
	            }
	        }
	        return -1;
	    }

	 
	 /**
	  * 还真是有很多api 都不熟悉啊
	  * HashMap.containsKey（key）- 该方法判断Map集合对象中是否包含指定的键名
	  * 如果找到已经包含的key 那么就失败，将他设置为数组长度（int）
	  * 否则添加进去
	  * 取出hashmap 中的值，如果为数组的长度那么就返回失败-1
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
	  * 这个解法的思想已经遇到不止一次了，要长记性
	  * 如果要比较   字符   的那么就 定义一个长度为26 的array 
	  * 每当有一个就++
	  * 取出的时候如果等于1，那么就返回，没有为1 的就返回-1
	  * 
	  * 
	  * 之前一直觉得这个算法不会按顺序返回，单其实后面一个循环也是按顺序取得，所以没有存在这个问题
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
	  * 这。。。。。学会利用api
	  * 第一次和最后一次出现的位置相同则视为同一个
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
