package leetcode._10IsMatch;

/**
 * @author XiaoLOrange
 * @time 2021.09.13
 * @title
 * @url https://leetcode-cn.com/problems/regular-expression-matching
 *
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *
 * 例：
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 */

public class Solution {

	/**
	 * 参考解法
	 * https://leetcode-cn.com/problems/regular-expression-matching/comments/86480
	 * . 46
	 * * 42
	 * \ 92
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		if(p.length() == 0) return s.length() == 0;

		char pc = p.charAt(0);
		boolean first_match = (s.length() != 0) &&
				(s.charAt(0) == pc || pc == '.');

		if(p.length() > 1 && p.charAt(1) == '*'){
			return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
		}else{
			return first_match && isMatch(s.substring(1), p.substring(1));
		}
	}

	/**
	 * {@link Solution#isMatch(String, String)} 基础上改进内存消耗，大幅度节约内存
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch2(String s, String p) {
		return isMatch2IM(s, p, 0, 0);
	}

	private boolean isMatch2IM(String s, String p, int sp, int pp){
		if(p.length() - pp == 0) return s.length() - sp == 0;

		char pc = p.charAt(pp);
		boolean first_match = (s.length() - sp != 0) &&
				(s.charAt(sp) == pc || pc == '.');

		if(p.length() - pp > 1 && p.charAt(pp + 1) == '*'){
			return isMatch2IM(s, p, sp, pp + 2) || (first_match && isMatch2IM(s, p, ++sp, pp));
		}else{
			return first_match && isMatch2IM(s, p, ++sp, ++pp);
		}
	}

}
