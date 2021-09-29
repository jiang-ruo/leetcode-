package leetcode._12IntToRoman;

/**
 * @author XiaoLOrange
 * @time 2021.09.15
 * @title
 * @url https://leetcode-cn.com/problems/integer-to-roman
 *
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 例：
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
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
