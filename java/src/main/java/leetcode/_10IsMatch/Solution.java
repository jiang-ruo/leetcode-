package leetcode._10IsMatch;

/**
 * @author XiaoLOrange
 * @time 2021.09.13
 * @title
 *
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
