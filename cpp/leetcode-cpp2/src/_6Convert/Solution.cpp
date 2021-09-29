//
// Created by XiaoLOrange on 2021/7/28.
//
//https://leetcode-cn.com/problems/longest-palindromic-substring/
//
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。注：N字形排列
//
//比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
//P   A   H   N
//A P L S I I G
//Y   I   R
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//请你实现这个将字符串进行指定行数变换的函数：
//string convert(string s, int numRows);
//
//例：
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I

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
