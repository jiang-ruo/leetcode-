#include "VectorUtil.h"
#include<iostream>

void xlo::print(vector<int> v) {
	cout << "[";
	for (char i = 0; i < v.size(); i++) {
		if (i == 0) {
			cout << *v.begin();
		} else {
			cout << ", " << *(v.begin() + i);
		}
	}
	cout << "]" << endl;
}
