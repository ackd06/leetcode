package zsz.develop.three;

import java.util.HashMap;

/**
 * Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * 最长连续序列 给定一个整数排序的数组，找到最长连续元素序列的长度。 例如, 给定[ 100，4，200，1，3，2， 最长的连续元素序列是[
 * 1，2，3，4 ]。返回长度：4。 你的算法应该运行在O（n）的复杂性。
 * 
 * @author zhangsz
 *
 */
public class LongestConsecutiveSequence {

	private int[] id; // access to component id (site indexed)
	private int count; // number of components

	/**
	 * 没有什么头绪
	 * 
	 * @param nums
	 * @return
	 */
	public int longestConsecutive(int[] nums) {

		
		return 0;
	}

	
	/**
	 * 我们将使用HashMap。 关键是要跟踪序列长度并将其存储在序列的边界点。 例如，因此，对于序列{1,2,3,4,5}，map.get（1）和map.get（5）都应返回5。

		每当将新元素n插入到地图中时，请执行以下两项操作：
		
		看看地图中是否存在n-1和n + 1，如果存在，则意味着在n旁边存在现有序列。 左和右的变量将是这两个序列的长度，而0表示没有序列，n稍后将是边界点。 将（左+右+ 1）作为关键值n存储到映射中。
		使用左和右分别定位序列的左侧和右侧的另一端，并用新的长度替换值。
		for循环中的所有内容都是O（1），所以总时间是O（n）。 如果你看到错误，请评论。 谢谢。
	 * @param num
	 * @return
	 */
	public int longestConsecutiveOtherOne(int[] num) {
	    int res = 0;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int n : num) {
	        if (!map.containsKey(n)) {
	            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
	            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
	            // sum: length of the sequence n is in
	            int sum = left + right + 1;
	            map.put(n, sum);
	            
	            // keep track of the max length 
	            res = Math.max(res, sum);
	            
	            // extend the length to the boundary(s)
	            // of the sequence
	            // will do nothing if n has no neighbors
	            map.put(n - left, sum);
	            map.put(n + right, sum);
	        }
	        else {
	            // duplicates
	            continue;
	        }
	    }
	    return res;
	}
	
}
