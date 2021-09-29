package leetcode;

import leetcode._12IntToRoman.Solution;
import leetcode.test.AbstractTestInfo;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author XiaoLOrange
 * @time 2021.09.15
 * @title
 */

public class _12IntToRomanTest extends AbstractTestInfo<String> {

	private Solution s = new Solution();

	@Override
	public boolean verify(Object[] params, String rs) {
		return s.intToRoman((int) params[0]).equals(rs);
	}

	@Override
	public void print(Object[] params, String rs) {
		System.out.printf("%s\t->%s\n", params[0], rs);
	}

	@Before
	public void itriBefor(){
		super.setIb(new Object[][]{
				{3},
				{4},
				{9},
				{58},
				{1994}
		});
	}

	@Test
	@SneakyThrows
	public void itri(){
		Method m = Solution.class.getMethod("intToRoman", int.class);
		super.doMethod(s, m);
	}

	@Test
	@SneakyThrows
	public void itri2(){
		Method m = Solution.class.getMethod("intToRoman2", int.class);
		super.doMethod(s, m);
	}

}
