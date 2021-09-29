package leetcode;

import com.alibaba.fastjson.JSON;
import leetcode._11MaxArea.Solution;
import leetcode.test.StatisTest;
import leetcode.test.TestInfo;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoLOrange
 * @time 2021.09.15
 * @title
 */

public class _11MaxAreaTest implements TestInfo<Integer> {

	private List ps = new ArrayList<>();
	private Solution s = new Solution();
	private int pointer = 0;

	@Before
//	@Test
	@SneakyThrows
	public void matBefore(){
		String path = _11MaxAreaTest.class.getResource("_11MaxAreaTest.json").getFile();
		File file = new File(URLDecoder.decode(path, StandardCharsets.UTF_8));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = br.readLine()) != null){
			sb.append(line);
		}
		line = sb.toString();
		List<int[]> ls = JSON.parseArray(line, int[].class);
		ps.addAll(ls);
		ps.add(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
		ps.add(new int[]{4, 3, 2, 1, 4});
		ps.add(new int[]{1, 2, 1});
		ps.add(new int[]{1, 1});
//		ps.add()
	}

	@Override
	public boolean verify(Object[] params, Integer rs) {
		return s.maxArea2((int[]) params[0]) == rs;
	}

	@Override
	public Object[] buildParams() {
		return new Object[]{
//				new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}
//				new int[]{4, 3, 2, 1, 4}
//				new int[]{1, 2, 1}
//				new int[]{1, 1}
				ps.get(pointer++)
				};
	}

	@Override
	public void print(Object[] params, Integer rs) {
		System.out.println(rs);
	}

	@Test
	@SneakyThrows
	public void mat(){
		StatisTest st = new StatisTest(this);
		Method m = Solution.class.getMethod("maxArea", int[].class);
		st.doMethod(ps.size(), s, m);
	}

	@Test
	@SneakyThrows
	public void mat2(){
		StatisTest st = new StatisTest(this);
		Method m = Solution.class.getMethod("maxArea2", int[].class);
		st.doMethod(ps.size(), s, m);
	}

	@Test
	@SneakyThrows
	public void mat3(){
		mat2();
		pointer = 0;
		StatisTest st = new StatisTest(this);
		Method m = Solution.class.getMethod("maxArea3", int[].class);
		st.doMethod(ps.size(), s, m);
	}
}
