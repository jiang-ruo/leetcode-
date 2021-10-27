package leetcode;

import leetcode._17LetterCombinations.Solution;
import leetcode.test.AbstractTestInfo;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author XiaoLOrange
 * @time 2021.09.30
 * @title
 */

public class _17LetterCombinationsTest extends AbstractTestInfo<List<String>> {

	private Solution s = new Solution();

	@Before
	public void lctBefore(){
		super.setIb(new Object[][]{
				{"23"}
		});
	}

	@Test
	@SneakyThrows
	public void lct(){
		Method m = Solution.class.getMethod("letterCombinations", String.class);
		super.doMethod(s, m);
	}

	@Test
	@SneakyThrows
	public void lct2(){
		Method m = Solution.class.getMethod("letterCombinations2", String.class);
		super.st.doMethod(s, m, buildParams());
	}

	@Test
	@SneakyThrows
	public void lct3(){
		Method m = Solution.class.getMethod("letterCombinations2", String.class);
		super.doMethod(s, m);
	}

}
