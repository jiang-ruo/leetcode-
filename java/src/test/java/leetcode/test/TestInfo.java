package leetcode.test;

/**
 * @author XiaoLOrange
 * @time 2021.07.22
 * @title
 */

public interface TestInfo<T> {

	int second = 1000;

	/**
	 * 对返回的结果进行校验，结果是否正确
	 * @param rs
	 * @return
	 */
	boolean verify(T rs);

	/**
	 * 执行方法测试时输入的参数
	 * @return
	 */
	Object[] buildParams();

	/**
	 * 打印输出的结果
	 * @param params
	 * @param rs
	 */
	void print(Object[] params, T rs);

}
