package leetcode._4FindMedianSortedArrays;

import java.util.Arrays;

/**
 * @author XiaoLOrange
 * @time 2021.07.22
 * @title
 * @url https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * TODO 时间复杂度O(log(m+n))
 * TODO 寻找更精简的写法
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 例：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */

public class Solution {

	/**
	 * 时间复杂度O(m+n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l = nums1.length + nums2.length;
		int[] a = new int[l];
		System.arraycopy(nums1, 0, a, 0, nums1.length);
		System.arraycopy(nums2, 0, a, nums1.length, nums2.length);
		Arrays.sort(a);

		int index = l / 2;
		if(l % 2 == 0){
			return ((double) (a[index - 1] + a[index])) / 2;
		}else return a[index];
	}

	/**
	 * 时间复杂度O(m+n)
	 * @author windliang https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArrays2(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int len = m + n;
		int left = -1, right = -1;
		int aStart = 0, bStart = 0;
		for (int i = 0; i <= len / 2; i++) {
			left = right;
			if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
				right = A[aStart++];
			} else {
				right = B[bStart++];
			}
		}
		if ((len & 1) == 0)
			return (left + right) / 2.0;
		else
			return right;
	}

}
