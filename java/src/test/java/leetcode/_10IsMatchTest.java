package leetcode;

import leetcode._10IsMatch.Solution;
import leetcode.test.StatisTest;
import leetcode.test.TestInfo;
import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author XiaoLOrange
 * @time 2021.09.15
 * @title
 */

public class _10IsMatchTest implements TestInfo<Boolean> {

	private int pointer = 0;
	private Solution s = new Solution();
	private Object[][] ps = new Object[][]{
			{"aa", "a"},
			{"aa", "a*"},
			{"ab", ".*"},
			{"aab", "c*a*b"},
			{"mississippi", "mis*is*p*."}
	};

	@Override
	public boolean verify(Object[] params, Boolean rs) {
		return s.isMatch((String)params[0], (String)params[1]) == rs;
	}

	@Override
	public Object[] buildParams() {
		return ps[pointer++];
	}

	@Override
	public void print(Object[] params, Boolean rs) {
		System.out.printf("%s\t: {%s, %s}\n", rs, params[0], params[1]);
	}

	@Test
	@SneakyThrows
	public void imt(){
		StatisTest st = new StatisTest(this);

		Method m = Solution.class.getMethod("isMatch", String.class, String.class);
		st.doMethod(ps.length, new Solution(), m);
	}

	@Test
	@SneakyThrows
	public void imt2(){
		StatisTest st = new StatisTest(this);

		Method m = Solution.class.getMethod("isMatch2", String.class, String.class);
		st.doMethod(ps.length, new Solution(), m);
	}
}
