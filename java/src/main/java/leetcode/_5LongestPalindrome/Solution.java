package leetcode._5LongestPalindrome;

/**
 * @author XiaoLOrange
 * @time 2021.07.26
 * @title 回文子串 - 正序反序相同的字符串
 *
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


	/**
	 * 以当前字符为中心计算回文字符串
	 * @param s
	 * @return
	 */
	public String longestPalindrome3(String s) {
		String rs = null;

		int len = s.length();
		int max = 1;
		int size, left, right;
		for (int i = 0; i < len; i++){
			int pointer = 1;
			char c = s.charAt(i);
			int pos = i + pointer;
			// 前后存在和当前回文字符相同字符的字符数量
			while (pos >= 0 && pos < len){
				if(c != s.charAt(pos)) break;
				pointer = -pointer;
				if(pointer >= 0) pointer++;
				pos = i + pointer;
			}

			// 若越界，则遍历过的都是回文字符
			if(pos < 0){
				size = -2 * pointer;
				left = 0;
				right = size;
				// 数组前端越界
			}else if(pos >= len){
				// 数组后端越界
				size = 2 * pointer - 1;
				left = i - pointer + 1;
				right = len;
			}else{
				// 数组没有越界
				// 统计以中心存在一定数量相同字符[1, +∞]的回文字符
				if(pointer < 0){
					pointer = -pointer;
					left = i - (pointer - 1);
					right = i + pointer + 1;
				}else{
					left = i - (pointer - 1);
					right = i + pointer;
				}
				while(left > 0 && right < len){
					// --left, right++;
					if(s.charAt(--left) != s.charAt(right++)) {
						// 当前left和right不符合条件
						left++;
						right--;
						break;
					}
				}
				size = right - left;
			}
			if(size > max){
				max = size;
				rs = s.substring(left, right);
			}
		}

		return rs == null ? s.substring(0, 1) : rs;
	}


	/**
	 * longestPalindrome3
	 * @param s
	 * @return
	 */
	public String longestPalindrome4(String s) {
		String rs = null;

		int len = s.length();
		int max = 1;
		int size, left, right;
		for (int i = 0; i < len; i++){
			char c = s.charAt(i);
			left = i;
			// 往后存在和当前字符相同字符的字符数量
			while (++i < len && c == s.charAt(i));
			// 出循环时的i不可用，因为要么右侧越界，要么当前i处的字符与c不同
			right = i--;

			// 寻找以这些字符为中心的回文字符
			while(left > 0 && right < len
					// 当前right和下一个left比较，当条件不成立时需要将left加回去以及right减回去
					// 左侧用于判断，右侧用于当左侧判断失败时将left和right重置
					&& (s.charAt(--left) == s.charAt(right++) || s.charAt(left++) == s.charAt(--right)));

			size = right - left;
			if(size > max){
				max = size;
				rs = s.substring(left, right);
			}
		}

		return rs == null ? s.substring(0, 1) : rs;
	}


	/**
	 * Manacher算法
	 * @source https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
	 * @param s
	 * @return
	 */
	public String longestPalindrome5(String s) {

		return null;
	}
}
