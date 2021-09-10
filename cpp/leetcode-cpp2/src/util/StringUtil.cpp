//
// Created by XiaoLOrange on 2021/7/28.
//

#include "StringUtil.h"
#include <ctime>

int seed = time(NULL);

string xlo::randomStr(int size) {
	srand(seed);
	char str[size + 1];
	int type;
	for (int i = 0; i < size; ++i) {
		type = rand() % 3;
		switch (type) {
			case 0:
				str[i] = 48 + rand() % 10;
			case 1:
				str[i] = 65 + rand() % 26;
			case 2:
				str[i] = 97 + rand() % 26;
		}
	}
	str[size] = '\0';
	return str;
}