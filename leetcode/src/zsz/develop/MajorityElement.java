package zsz.develop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
/**
 * 169. Majority Element 
		Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
		
		You may assume that the array is non-empty and the majority element always exist in the array.
		
		169。大多数元素
		给定一个大小n的数组，查找大多数元素。大多数元素是出现超过⌊N / 2⌋倍元。
		您可以假定数组是非空的，而数组中的大多数元素都是存在的。
 * @author zhangshengzhong
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,2,3,4,5};
		int majorityElementMyOne = majorityElementMyOne(nums);
		System.err.println(">>>>>"+ majorityElementMyOne);
	}
//	/**
//	 * 不知为何编译错误，忽略
//	 * @param nums
//	 * @return
//	 */
//	public static int majorityElementMyOne(int[] nums) {
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			if (map.containsKey(nums[i])) {
//				Integer iCount = map.get(nums[i]);
//				map.put(nums[i], iCount+1);
//			}else {
//				map.put(nums[i], 1);
//			}
//		}
//		
//		Set<Entry<Integer,Integer>> entrySet = map.entrySet();
//		Iterator<Entry<Integer, Integer>> iterator = entrySet.iterator();
//		if (iterator.hasNext()) {
//			Entry<Integer, Integer> next = iterator.next();
//			Integer conut = next.getValue();
//			if (conut>(nums.length/2)) {
//				return next.getKey();
//			}
//		}
//		return -1;	}
//	
	
	/**
	 * 这个思路厉害了，题目已经给出了说会大于一半了。
	 * 那我们先给她排序一下，取出中间的数不就结了
	 * @param nums
	 * @return
	 */
	public int majorityElemenOtherOne(int[] nums) {
	    Arrays.sort(nums);
	    return nums[nums.length / 2];
	}
	
	
	/**
	 * 看不太懂，我觉得他是错误的解法，但运行结果竟然是正确的
	 * 问题就出在数量大于一半，所以count 总会等于正确时的数
	 * @param nums
	 * @return
	 */
	public static int majorityElementOtherTwo(int[] nums) {
        int res=nums[0], count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==res) count++;
            else if(--count==0){//这个是什么意思？如果不相等，让他的数量减少一个，且等于0
            	// 实例分析一下，如果第二个不等于第一个，前面一个的数量已经等于1，那么可能就不是他了，那么就开始比对第二个
            	// 比如前面3个1 conut ＝3，后面2，3，4，5，....问题就出在数量大于一半， 总会等于正确时的数
                res=nums[i];
                count=1;
            }
        }
        return res;
    }
	
/**
 * 跟我的解法出奇的相似，但是它运行是正确的
 * @param nums
 * @return
 */
	public static int majorityElement(int[] nums) {
		int half = nums.length /2;
		HashMap map =new HashMap();
		for(int i= 0;i<nums.length;i++){
		int key = nums[i];
		if(map.containsKey(key)){
		map.put(key,(int)map.get(key) + 1);
		}else{
		map.put(key,1);
		}
		}

		    Iterator it = map.keySet().iterator();
		    int max = 0;
		    int maxKey = 0;
		    while(it.hasNext()){
		        int key = (int)it.next();
		        int val = (int)map.get(key);
		        if(val >= half && val > max){
		            max = val;
		            maxKey = key;
		        }
		    }
		    return maxKey;
		}


}
