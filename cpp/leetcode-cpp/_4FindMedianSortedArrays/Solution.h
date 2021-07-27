#pragma once
#include <vector>

#ifndef _4FMSA
#define _4FMSA

using namespace std;

namespace _4Solution {
	class Solution {

	private:
		int getNum(vector<int>& nums1, int s1, int e1, vector<int>& nums2, int s2, int e2, int k);

	public:
		double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2);

	};
}


#endif // !_4FMSA