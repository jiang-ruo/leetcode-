#include <iostream>
#include "_4FindMedianSortedArrays/Solution.h"
#include "util/VectorUtil.h"
#include <vector>
#include <random>
#include <algorithm>

using namespace std;

vector<int> buildParams() {
	vector<int> v;
	int size = 30 + (rand() % 21);
	for (char i = 0; i < size; i++) {
		v.push_back(rand() % 301);
	}
	sort(v.begin(), v.begin() + size);
	return v;
}

int main() {
	vector<int> v1 = buildParams();
	vector<int> v2 = buildParams();
	//vector<int> v1 = {  };
	//vector<int> v2 = { 3 };

	_4Solution::Solution s;
	cout << s.findMedianSortedArrays(v1, v2) << endl;
	return 0;
}

