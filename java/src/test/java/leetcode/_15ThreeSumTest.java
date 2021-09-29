package leetcode;

import com.alibaba.fastjson.JSON;
import leetcode._15ThreeSum.Solution;
import leetcode.test.AbstractTestInfo;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoLOrange
 * @time 2021.09.24
 * @title
 */

public class _15ThreeSumTest extends AbstractTestInfo<List<List<Integer>>> {

	private Solution s = new Solution();

	@Override
	public boolean verify(Object[] params, List<List<Integer>> rs) {
		return rs.stream().allMatch((list) -> {
			int[] ps = (int[]) params[0];
			//TODO 判断rs中的数字是否在ps中
			return list.stream().reduce(0, Integer::sum) == 0;
		});
	}

	@Override
	public void print(Object[] params, List<List<Integer>> rs) {
		System.out.println(JSON.toJSON(rs));
	}

	@Before
	public void tsBefor(){
		List<Object[]> ps = new ArrayList<>();
		ps.add(new Object[]{new int[]{-1, 0, 1, 2, -1, -4}});
		ps.add(new Object[]{new int[]{}});
		ps.add(new Object[]{new int[]{0}});
		ps.add(new Object[]{new int[]{0, 0, 0, 0}});
		ps.add(new Object[]{new int[]{0, 1, 1}});
		ps.add(new Object[]{new int[]{-2, 0, 1, 1, 2}});
		ps.add(new Object[]{new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}});
		super.setIb(ps);
	}

	@Test
	@SneakyThrows
	public void ts(){
		Method m = Solution.class.getMethod("threeSum", int[].class);
		super.doMethod(s, m);
	}

	@Test
	@SneakyThrows
	public void ts2(){
		Method m = Solution.class.getMethod("threeSum2", int[].class);
		super.doMethod(s, m);
	}
}
