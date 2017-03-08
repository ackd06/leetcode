package zsz.develop.three;

/**
 * Median of Two Sorted Arrays here are two sorted arrays nums1 and nums2 of
 * size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * Example 1: nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 这里有两个已排序数组nums1和nums2大小m和n分别为。 找出两个排序数组的中位数。总的运行时间复杂度应该是O（log（m + n））。 例1：
 * nums1 = [ 1，3 ] nums2 = [ 2 ] 中位数为2 例2： nums1 = [ 1，2 ] nums2 = [ 3，4 ]
 * 中位数是（2 + 3）/ 2 = 2.5
 * 
 * @author zhangsz
 *
 */
public class MedianOfTwoSortedArrays {

	/**
	 * 其中一种可行方案就是让，两个已经排好序的数组合并，然后再取出中位数
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArraysMyOne(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		
		if ( n== 0 && m == 0) {
			return 0;
		}
		if (n == 0 && m > 0) {
			
			if (m % 2 == 0) {
				return (nums2[m / 2] + nums2[m / 2 + 1]) / 2;

			} else {
				return nums2[m / 2] / 2;
			}

		}
		if (n > 0 && m == 0) {
			
			if (n % 2 == 0) {
				return (nums2[n / 2] + nums2[n / 2 + 1]) / 2;

			} else {
				return nums2[n / 2] / 2;
			}

		}
		
		int[] newNums = new int[n+m];//不对啊
		if (nums1[0] <= nums2[0]) {
			for(int i =0;i< n;i++){
				for (int j = i; j < m; j++) {
					if (nums1[i]<= nums2[j]) {
//						newNums[i] 
					}
					
				}
			}
		}
		

		return 0;
	}
	
	
	
	/**
	 * 分治发处理  O(log (m+n)).
	 * @param A
	 * @param B
	 * @return
	 */
	 public double findMedianSortedArraysOtherOne(int A[], int B[]) {
	        int len = A.length + B.length;
	        if (len % 2 == 1) {
	            return findKth(A, 0, B, 0, len / 2 + 1);
	        }
	        return (
	            findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)
	        ) / 2.0;
	    }

	    // find kth number of two sorted array
	    public static int findKth(int[] A, int A_start,
	                              int[] B, int B_start,
	                              int k){		
			if (A_start >= A.length) {
				return B[B_start + k - 1];
			}
			if (B_start >= B.length) {
				return A[A_start + k - 1];
			}

			if (k == 1) {
				return Math.min(A[A_start], B[B_start]);
			}
			
			int A_key = A_start + k / 2 - 1 < A.length
			            ? A[A_start + k / 2 - 1]
			            : Integer.MAX_VALUE;
			int B_key = B_start + k / 2 - 1 < B.length
			            ? B[B_start + k / 2 - 1]
			            : Integer.MAX_VALUE; 
			
			if (A_key < B_key) {
				return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
			} else {
				return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
			}
		}

}
