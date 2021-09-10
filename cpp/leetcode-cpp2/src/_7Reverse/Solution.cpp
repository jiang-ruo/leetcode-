//
// Created by XiaoLOrange on 2021/7/30.
//

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