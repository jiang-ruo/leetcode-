package leetcode;

import leetcode._1TwoSum.Solution;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author XiaoLOrange
 * @time 2021.07.21
 * @title
 */

public class _1TwoSumTest {

	@Test
	public void preTst(){
		Map<Integer, List<Integer>> map = new HashMap<>();
		map.compute(1, (k, v) -> {
			System.out.println(v);
			return v;
		});
	}

	@Test
	public void tst(){
		int[] is = new int[30];
		Random r = new Random();
		for (int i = 0; i < is.length; i++){
			is[i] = r.nextInt();
		}
		int index1 = r.nextInt(is.length);
		int num1 = is[index1];
		int index2;
		while ((index2 = r.nextInt(is.length)) == index1);
		int num2 = is[index2];
		int target = num1 + num2;

		long t1 = System.nanoTime();
		int[] rs = new Solution().twoSum(is, target);
		long t2 = System.nanoTime();
		System.out.println(t2 - t1);
		System.out.printf("(%d, %d)\n", rs[0], rs[1]);
		System.out.println(is[rs[0]] + is[rs[1]] == target);

		t1 = System.nanoTime();
		rs = new Solution().twoSum2(is, target);
		t2 = System.nanoTime();
		System.out.println(t2 - t1);
		System.out.printf("(%d, %d)\n", rs[0], rs[1]);
		System.out.println(is[rs[0]] + is[rs[1]] == target);

		t1 = System.nanoTime();
		rs = new Solution().twoSum3(is, target);
		t2 = System.nanoTime();
		System.out.println(t2 - t1);
		System.out.printf("(%d, %d)\n", rs[0], rs[1]);
		System.out.println(is[rs[0]] + is[rs[1]] == target);
	}

}
