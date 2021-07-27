#include "Solution.h"
#include <iostream>	
#include <algorithm>

/*
* @resource windliang https ://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
*/
double _4Solution::Solution::findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2){
	int size1 = nums1.size() - 1;
	int size2 = nums2.size() - 1;

	// 奇偶数合并，奇数left和right相同
	int left = (size1 + size2 + 3) / 2;
	int right = (size1 + size2 + 4) / 2;

	return ((double)(this->getNum(nums1, 0, size1, nums2, 0, size2, left)
		+ this->getNum(nums1, 0, size1, nums2, 0, size2, right))) / 2;
}

int _4Solution::Solution::getNum(vector<int>& nums1, int s1, int e1, vector<int>& nums2, int s2, int e2, int k) {
	int len1 = e1 - s1 + 1;
	int len2 = e2 - s2 + 1;
	// 保证空的数组一定是nums1
	if (len1 > len2) return this->getNum(nums2, s2, e2, nums1, s1, e1, k);

	if (len1 == 0) return (s2 == 0 && k == 0) ? nums2[s2] : nums2[s2 + k - 1];
	if (k == 1) return min(nums1[s1], nums2[s2]);

	int halfK = k / 2;
	int i1 = (s1 == 0 && k == 0) ? 0 : s1 + min(len1, halfK) - 1;
	int i2 = (s2 == 0 && k == 0) ? 0 : s2 + min(len2, halfK) - 1;

	return nums1[i1] > nums2[i2] ?
		this->getNum(nums1, s1, e1, nums2, i2 + 1, e2, k - (i2 - s2 + 1)) :
		this->getNum(nums1, i1 + 1, e1, nums2, s2, e2, k - (i1 - s1 + 1));
}