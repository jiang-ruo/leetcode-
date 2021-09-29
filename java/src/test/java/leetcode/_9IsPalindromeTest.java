package leetcode;

import leetcode._9IsPalindrome.Solution;
import leetcode.test.StatisTest;
import leetcode.test.TestInfo;
import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author XiaoLOrange
 * @time 2021.09.12
 * @title
 */

public class _9IsPalindromeTest implements TestInfo<Boolean> {
	@Override
	public boolean verify(Object[] params, Boolean rs) {
		return true;
	}

	@Override
	public Object[] buildParams() {
		return new Object[]{
			10
		};
	}

	@Override
	public void print(Object[] params, Boolean rs) {
		System.out.println(rs);
	}

	@Test
	@SneakyThrows
	public void mat(){
		Method m = Solution.class.getMethod("isPalindrome", int.class);
		StatisTest st = new StatisTest(this);
		st.doMethod(1000, new Solution(), m, buildParams());
	}
}
