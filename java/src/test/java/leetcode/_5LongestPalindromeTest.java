package leetcode;

import leetcode._5LongestPalindrome.Solution;
import leetcode.test.StatisTest;
import leetcode.test.TestInfo;
import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author XiaoLOrange
 * @time 2021.07.26
 * @title
 */

public class _5LongestPalindromeTest implements TestInfo<String> {

	/**
	 *
	 * @author windliang https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
	 * @param rs
	 * @return
	 */
	@Override
	public boolean verify(String rs) {
		int len = rs.length();
		if(len == 0) return false;
		int size = len / 2;
		for (int i = 0; i < size; i++){
			if(rs.charAt(i) != rs.charAt(len - i - 1)) return false;
		}
		return true;
	}

	@Override
	public Object[] buildParams() {
		return new Object[]{"a"};
//		return new Object[]{"ccc"};
//		return new Object[]{StringUtil.randomString(1000)};
//		return new Object[]{"321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123"};
	}

	@Override
	public void print(Object[] params, String rs) {
		System.out.printf("result: %s\n", rs);
	}

	@Test
	@SneakyThrows
	public void lpt(){
		StatisTest st = new StatisTest(this);
		Object[] ps = buildParams();

		Method m = Solution.class.getMethod("longestPalindrome2", String.class);
		st.doMethod(1000, new Solution(), m, ps);
	}

	@Test
	public void lptVerifyTest(){
		System.out.println(verify("3210123"));
	}
}
