//
// Created by XiaoLOrange on 2021/7/28.
//

#include <ctime>
#include <iostream>
#include <cmath>
#include "Solution.h"
#include "../util/StringUtil.h"

void _6Solution::Solution::doMethod() {
	srand(time(NULL));
	string str = xlo::randomStr(1 + rand() % 20);
//	int rows = 1 + rand() % 5;
//	string rs = s.convert(str, rows);
	string rs = convert("PAYPALISHIRING", 1);
	cout << rs << endl;
}

string _6Solution::Solution::convert(string s, int numRows) {
	if(numRows == 1) return s;
	int len = s.size();
	string preRs[numRows];
	int correct = (numRows - 1) * 2;
	for (int i = 0; i < len; ++i) {
		int index = i % correct;
		if(index >= numRows) index = correct - index;
		preRs[index] += s[i];
	}
	string rs = "";
	for (int i = 0; i < numRows; ++i) {
		rs += preRs[i];
	}
	return rs;
}

string _6Solution::Solution::convert2(string s, int numRows) {
	if(numRows == 1) return s;
	int len = s.size();
	char rs[len + 1];
	rs[len] = '\0';
	int correct = (numRows - 1);
	int pointer[numRows];
	pointer[0] = ceil((float)len / (correct * 2));
	for (int i = 1; i < correct; ++i) {
		pointer[i] = ceil(((float)(len - i)) / correct);
	}
	pointer[numRows - 1] = ceil(((float)len - numRows + 1) / (correct * 2));
	for (int i = 0; i < len; ++i) {
		int index = i % correct;
		// 第index行
		if(index >= numRows) index = correct - index;
		// line begin: ceil(len / correct); = ceil(14 / 6) = 3
		// len = len - len(line1);
		// line 2: ceil(len / (correct / 2)); = ceil(13 / 3) = 5
		// line 3: ceil(len / (correct / 2)); = ceil(12 / 3) = 4
		// line end: ceil(len / correct); = ceil(11 / 6) = 2
	}
	return rs;
}

string _6Solution::Solution::convert3(string s, int numRows) {
	if(numRows == 1) return s;
	int len = s.size();
	string preRs[numRows];
	int p = 0, flag = -1;
	for (int i = 0; i < len; ++i) {
		preRs[p] += s[i];
		if(p == 0 || p == numRows - 1) flag = -flag;
		p += flag;
	}
	string rs;
	for (int i = 0; i < numRows; ++i) {
		rs += preRs[i];
	}
	return rs;
}
