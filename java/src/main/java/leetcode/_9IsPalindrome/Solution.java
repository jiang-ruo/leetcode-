package leetcode._9IsPalindrome;

/**
 * @author XiaoLOrange
 * @time 2021.09.12
 * @title
 * @url https://leetcode-cn.com/problems/palindrome-numberhttps://leetcode-cn.com/problems/palindrome-number
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 例：
 * 输入：x = 121
 * 输出：true
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */

public class Solution {

	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		int y = 0, tmp = x;
		while(tmp != 0){
			y *= 10;
			y += tmp % 10;
			tmp /= 10;
		}
		return x == y;
	}

}
