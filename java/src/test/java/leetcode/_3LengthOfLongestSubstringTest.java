package leetcode;

import leetcode._3LengthOfLongestSubstring.Solution;
import leetcode.test.StatisTest;
import leetcode.test.TestInfo;
import lombok.SneakyThrows;
import org.junit.Test;
import xlo.util.StringUtil;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author XiaoLOrange
 * @time 2021.07.22
 * @title
 */

public class _3LengthOfLongestSubstringTest implements TestInfo<Integer> {

	private Random r = new Random();

	@Override
	public boolean verify(Object[] params, Integer rs) {
		return true;
	}

	@Override
	public Object[] buildParams() {
		String s = StringUtil.randomString(this.r.nextInt(100));
		return new Object[]{s};
	}

	@Override
	public void print(Object[] params, Integer rs) {
//		System.out.println(params[0] + " : " + rs);
	}

	@Test
	@SneakyThrows
	public void lolst(){
		StatisTest st = new StatisTest(this);

		Method m = Solution.class.getMethod("lengthOfLongestSubstring", String.class);
		st.doMethod(new Solution(), m);

		m = Solution.class.getMethod("lengthOfLongestSubstring2", String.class);
		st.doMethod(new Solution(), m);
	}
}
