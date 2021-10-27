package leetcode;

import leetcode._18FourSum.Solution;
import leetcode.test.AbstractTestInfo;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author XiaoLOrange
 * @time 2021.10.01
 * @title
 */

public class _18FourSumTest extends AbstractTestInfo<List<List<Integer>>> {

	private Solution s = new Solution();

	@Before
	public void fstBefore(){
		super.setIb(new Object[][]{
				{new int[]{1, 0, -1, 0, -2, 2}, 0},
				{new int[]{2, 2, 2, 2, 2}, 8},
				{new int[]{-5,5,4,-3,0,0,4,-2}, 4},
		});
	}

	@Test
	@SneakyThrows
	public void fst(){
		Method m = Solution.class.getMethod("fourSum", int[].class, int.class);
		super.doMethod(s, m);
	}

	@Test
	@SneakyThrows
	public void fst2(){
		Method m = Solution.class.getMethod("fourSum2", int[].class, int.class);
		super.doMethod(s, m);
	}

}
