package leetcode;

import leetcode._16ThreeSumClosest.Solution;
import leetcode.test.AbstractTestWithResult;
import leetcode.test.bean.Params;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author XiaoLOrange
 * @time 2021.09.26
 * @title
 */

public class _16ThreeSumClosestTest extends AbstractTestWithResult<Integer> {

	private Solution s = new Solution();

	@Before
	public void tsctBefor(){
		super.setIb(new Params[]{
				new Params(new Object[]{new int[]{-1, 2, 1, -4}, 1}, 2),
				new Params(new Object[]{new int[]{1, 1, -1, -1, 3}, -1}, -1),
				new Params(new Object[]{new int[]{-111, -111, 3, 6, 7, 16, 17, 18, 19}, 13}, 16),
				new Params(new Object[]{new int[]{0, 0, 0}, 1}, 0)
		});
	}

	@Test
	@SneakyThrows
	public void tsct(){
		Method m = Solution.class.getMethod("threeSumClosest", int[].class, int.class);
		super.doMethod(s, m);
	}

	@Test
	@SneakyThrows
	public void tsct2(){
		Method m = Solution.class.getMethod("threeSumClosest2", int[].class, int.class);
		super.doMethod(s, m);
	}

	@Test
	@SneakyThrows
	public void tsct3(){
		Method m = Solution.class.getMethod("threeSumClosest3", int[].class, int.class);
		super.doMethod(s, m);
	}
}
