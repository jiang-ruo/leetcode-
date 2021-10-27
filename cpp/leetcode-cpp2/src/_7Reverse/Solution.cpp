//
// Created by XiaoLOrange on 2021/7/30.
// https://leetcode-cn.com/problems/reverse-integer/
//
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//如果反转后整数超过 32 位的有符号整数的范围[2^31, 2^31 - 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 例：
//输入：x = 123
//输出：321
//
//输入：x = -123
//输出：-321

#include <random>
#include <iostream>
#include "Solution.h"

void _7Solution::Solution::doMethod(){
//	srand(NULL);
//	int x = rand() * 10000 - 5000;
//	int rs = reverse(1534236469);
	int rs = reverse(-2147483648);
	cout << rs << endl;
}

int _7Solution::Solution::reverse(int x){
	bool negative = x < 0;
	string str = to_string(negative ? -x : x);
	string rs = negative ? "-" : "";
	for (int i = str.size() - 1 ; i >= 0; i--) {
		rs += str[i];
	}
	try{
		return stoi(rs);
	} catch (exception e) {
		return 0;
	}
}

int _7Solution::Solution::reverse2(int x){
	int rs = 0;
	while(x != 0){
		int n = x % 10;
		if(rs > 214748364 || (rs == 214748364 && n > 7)
		   || rs < -214748364 || (rs == -214748364 && n < -8)) return 0;
		rs *= 10;
		rs += n;
		x /= 10;
	}
	return rs;
}
