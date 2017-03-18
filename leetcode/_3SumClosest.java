package zsz.develop.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 3Sum Closest
 * 
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * 3Sum最近
 * 
 * 给定n个整数的数组S，在S中找到三个整数，使得和最接近给定数目target。 返回三个整数的和。 您可以假设每个输入都有一个解决方案。
 * 
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author zhangsz
 *
 */
public class _3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
	
		Arrays.sort(nums);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0;i<nums.length -2;i++){// 循环所有可能为第一个的值
			int lo = i+1;int hi = nums.length;
			int sum = nums[i]+nums[lo]+ nums[hi];
			int x = Math.abs(target - sum);//返回的绝对值
			map.put(x, sum);
			
		}
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		Map<Integer, Integer> sortMapByKey = sortMapByKey(map);
		Integer integer = getFirstOrNull(sortMapByKey);
		
		return map.get(integer);
	}
	 /**
     * 获取map中第一个数据值
     *
     * @param <K> Key的类型
     * @param <V> Value的类型
     * @param map 数据源
     * @return 返回的值
     */
    public static <K, V> V getFirstOrNull(Map<K, V> map) {
        V obj = null;
        for (Entry<K, V> entry : map.entrySet()) {
            obj = entry.getValue();
            if (obj != null) {
                break;
            }
        }
        return obj;
    }
	
	  /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static Map<Integer, Integer> sortMapByKey(Map<Integer, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<Integer, Integer> sortMap = new TreeMap<Integer, Integer>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }
	
    
    
    /**
     * 其他人的解法，好一些
     * @param num
     * @param target
     * @return
     */
    public int threeSumClosestOtherOne(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1, end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (sum > target) {
					end--;
				} else {
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}

	
}
