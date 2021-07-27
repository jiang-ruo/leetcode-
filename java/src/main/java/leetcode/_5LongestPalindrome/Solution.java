package leetcode._5LongestPalindrome;

/**
 * @author XiaoLOrange
 * @time 2021.07.26
 * @title 回文子串 - 正序反序相同的字符串
 */

public class Solution {

	/**
	 * 暴力解法
	 * @author windliang https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		String rs = "";
		int max = 0, len = s.length();
		for (int i = 0; i < len; i++){
			for(int j = i + 1; j <= len; j++){
				String str = s.substring(i, j);
				if(isPalindrome(str) && str.length() > max){
					rs = str;
					max = str.length();
				}
			}
		}
		return rs.length() == 0 ? s.substring(0, 1) : rs;
	}

	/**
	 * 暴力解法
	 * 小优化
	 * @param s
	 * @return
	 */
	public String longestPalindrome2(String s) {
		String rs = null;
		int max = 1, len = s.length();
		for (int i = 0; i < len; i++){
			for(int j = i + max; j <= len; j++){
				String str = s.substring(i, j);
				if(isPalindrome(str) && str.length() > max){
					rs = str;
					max = str.length();
				}
			}
		}
		return rs == null ? s.substring(0, 1) : rs;
	}

	/**
	 *
	 * @author windliang https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
	 * @param rs
	 * @return
	 */
	private boolean isPalindrome(String rs){
		int len = rs.length();
		if(len == 0) return false;
		int size = len / 2;
		for (int i = 0; i < size; i++){
			if(rs.charAt(i) != rs.charAt(len - i - 1)) return false;
		}
		return true;
	}
}
