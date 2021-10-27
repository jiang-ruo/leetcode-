package leetcode._12IntToRoman;

/**
 * @author XiaoLOrange
 * @time 2021.09.15
 * @title
 *
 */

public class Solution {

	/**
	 * 罗马数字
	 * I             1
	 * V             5
	 * X             10
	 * L             50
	 * C             100
	 * D             500
	 * M             1000
	 *
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		// M - 900 1000
		int remainder = num / 1000;
		num -= (remainder * 1000);
		while(remainder-- > 0) sb.append("M");
		if(num >= 900){
			sb.append("CM");
			num -= 900;
		}

		// D - 400 500
		remainder = num / 500;
		num -= (remainder * 500);
		while(remainder-- > 0) sb.append("D");
		if(num >= 400){
			sb.append("CD");
			num -= 400;
		}

		// C - 90 100
		remainder = num / 100;
		num -= (remainder * 100);
		while(remainder-- > 0) sb.append("C");
		if(num >= 90){
			sb.append("XC");
			num -= 90;
		}

		// L - 40 50
		remainder = num / 50;
		num -= (remainder * 50);
		while(remainder-- > 0) sb.append("L");
		if(num >= 40){
			sb.append("XL");
			num -= 40;
		}

		// X - 9 10
		remainder = num / 10;
		num -= (remainder * 10);
		while(remainder-- > 0) sb.append("X");
		if(num >= 9){
			sb.append("IX");
			num -= 9;
		}

		// V - 4 5
		remainder = num / 5;
		num -= (remainder * 5);
		while(remainder-- > 0) sb.append("V");
		if(num >= 4){
			sb.append("IV");
			num -= 4;
		}

		while(num-- > 0) sb.append("I");
		return sb.toString();
	}

	/**
	 * 罗马数字
	 * I             1
	 * V             5
	 * X             10
	 * L             50
	 * C             100
	 * D             500
	 * M             1000
	 *
	 * @param num
	 * @return
	 */
	public String intToRoman2(int num) {
		StringBuilder sb = new StringBuilder();
		int[] vs = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] ss = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		for (int i = 0; i < 13; i++){
			int remainder = num / vs[i];
			num -= (remainder * vs[i]);
			while(remainder-- > 0) sb.append(ss[i]);
		}
		return sb.toString();
	}

}
