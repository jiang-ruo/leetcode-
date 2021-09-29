package leetcode;

import leetcode._8MyAtoi.Solution;
import leetcode.test.StatisTest;
import leetcode.test.TestInfo;
import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author XiaoLOrange
 * @time 2021.09.10
 * @title
 */

public class _8MyAtoiTest implements TestInfo<Integer> {

	private String[] ps = new String[]{
			"sad-4193 lmljkh;l",
			"words and 987",
			"+1",
			"+0032",
			"-99999999999",
			"99999999999947758079",
			"-9999999999947758079",
			"42",
			"  0000000000012345678",
			"   54",
			"2147483648",
			"",
			"-91283472332"
	};

	private int pointer = 0;

	private Solution solution = new Solution();

	public _8MyAtoiTest() throws NoSuchMethodException {
	}

	@Override
	public boolean verify(Object[] params, Integer rs) {
		return solution.myAtoi2((String) params[0]) == rs;
	}

	@Override
	public Object[] buildParams() {
		return new Object[]{
				ps[pointer++]
		};
	}

	@Override
	public void print(Object[] params, Integer rs) {
		System.out.printf("%d, \"%s\"\n", rs, params[0]);
	}

	@Test
	@SneakyThrows
	public void mat(){
		Method m = Solution.class.getMethod("myAtoi", String.class);
		StatisTest st = new StatisTest(this);
		st.doMethod(ps.length, solution, m);
	}

	@Test
	@SneakyThrows
	public void mat2(){
		StatisTest st = new StatisTest(this);
		Method m = Solution.class.getMethod("myAtoi2", String.class);
		st.doMethod(ps.length, solution, m);
	}

	@Test
	@SneakyThrows
	public void mat3(){
		StatisTest st = new StatisTest(this);
		Method m = Solution.class.getMethod("myAtoi3", String.class);
		st.doMethod(ps.length, solution, m);
	}

	@Test
	@SneakyThrows
	public void mat4(){
		mat3();
		pointer = 0;
		StatisTest st = new StatisTest(this);
		Method m = Solution.class.getMethod("myAtoi4", String.class);
		st.doMethod(ps.length, solution, m);
	}
}
