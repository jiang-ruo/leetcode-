package leetcode._9IsPalindrome;

/**
 * @author XiaoLOrange
 * @time 2021.09.12
 * @title
 *
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
