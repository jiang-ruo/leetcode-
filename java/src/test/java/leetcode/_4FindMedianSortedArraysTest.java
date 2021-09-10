package leetcode;

import leetcode._4FindMedianSortedArrays.Solution;
import leetcode.test.StatisTest;
import leetcode.test.TestInfo;
import lombok.SneakyThrows;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

/**
 * @author XiaoLOrange
 * @time 2021.07.22
 * @title
 */

public class _4FindMedianSortedArraysTest implements TestInfo<Double> {

	private Random r = new Random();

	@Override
	public boolean verify(Object[] params, Double rs) {
		return true;
	}

	@Override
	public Object[] buildParams() {
		int[] a1 = random();
		int[] a2 = random();
//		int[] a1 = new int[]{1, 2};
//		int[] a2 = new int[]{3, 4};
		return new Object[]{a1, a2};
	}

	private int[] random(){
		int[] is = new int[this.r.nextInt(500)];
		for (int i = 0; i < is.length; i++){
			is[i] = this.r.nextInt();
		}
		Arrays.sort(is);
		return is;
	}

	@Override
	public void print(Object[] params, Double rs) {
		int l1 = ((int[])params[0]).length;
		int l2 = ((int[])params[1]).length;
		int[] a = new int[l1 + l2];
		System.arraycopy(params[0], 0, a, 0, l1);
		System.arraycopy(params[1], 0, a, l1, l2);
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println(rs);
	}

	@Test
	public void preFmsat(){
		int i = 0;
		System.out.println(i++);
		System.out.println(++i);
	}

	@Test
	@SneakyThrows
	public void fmsat(){
		int second = 1000;
		StatisTest st = new StatisTest(this);
		Object[] ps = buildParams();

		Method m = Solution.class.getMethod("findMedianSortedArrays", int[].class, int[].class);
		st.doMethod(second, new Solution(), m, ps);

		m = Solution.class.getMethod("findMedianSortedArrays2", int[].class, int[].class);
		st.doMethod(second, new Solution(), m, ps);
	}
}
