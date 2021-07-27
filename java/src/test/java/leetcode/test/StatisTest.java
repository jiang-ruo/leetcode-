package leetcode.test;

import lombok.SneakyThrows;
import org.junit.Assert;

import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @author XiaoLOrange
 * @time 2021.07.22
 * @title
 * 内存统计不准确，因为jvm回收内存时间不确定
 */

public class StatisTest implements TestInfo {

	private final static int DEFAULT_COUNT = 10000;
//	r.gc() 及其消耗时间 - 可以考虑放在for循环外
	private Runtime r = Runtime.getRuntime();

	private TestInfo ti;
	private long standardTime;
	private long standardMemory;

	public StatisTest(TestInfo ti){
		this(ti, true);
	}

	public StatisTest(TestInfo ti, boolean subStandard){
		this.ti = ti;
		if(subStandard) buildStandardPay();
	}

	/**
	 * 测算反射执行方法的消耗
	 */
	@SneakyThrows
	private void buildStandardPay(){
		Method method = StatisTest.class.getDeclaredMethod("testMethod");
		long[] tm = runMethod(StatisTest.DEFAULT_COUNT, this, method);
		this.standardTime = tm[0];
		this.standardMemory = tm[1];
	}

	private void testMethod(){}

	/**
	 *
	 * @param obj
	 * @param method
	 * @param params
	 * @return [time, memory]
	 */
	public void doMethod(Object obj, Method method, Object... params){
		doMethod(StatisTest.DEFAULT_COUNT, obj, method, params);
	}
	/**
	 *
	 * @param obj
	 * @param method
	 * @return [time, memory]
	 */
	public void doMethod(Object obj, Method method){
		doMethod(StatisTest.DEFAULT_COUNT, obj, method);
	}

	/**
	 * 先校验方法执行结果正确，
	 * 然后对方法进行多次测试计算平均值
	 * @param count
	 * @param obj
	 * @param method
	 * @param params
	 */
	@SneakyThrows
	public void doMethod(int count, Object obj, Method method, Object... params){
		Object rs = method.invoke(obj, params);

		long[] tm = runMethod(count, obj, method, params);

		this.ti.print(params, rs);
		Assert.assertTrue(this.ti.verify(rs));
//		System.out.printf("time: %dns\n", tm[0] - this.standardTime);
//		System.out.printf("memory: %dB\n", tm[1] - this.standardMemory);
		printTime(tm[0] - this.standardTime);
		printMemory(tm[1] - this.standardMemory);
		System.out.println();
	}

	/**
	 * 对方法进行多次测试计算平均值
	 * @param count
	 * @param obj
	 * @param method
	 */
	@SneakyThrows
	public void doMethod(int count, Object obj, Method method){
		long[] tm = runMethod(count, obj, method, this.ti);

//		System.out.printf("time: %dns\n", tm[0] - this.standardTime);
//		System.out.printf("memory: %dB\n", tm[1] - this.standardMemory);
		printTime(tm[0] - this.standardTime);
		printMemory(tm[1] - this.standardMemory);
		System.out.println();
	}

	private void printTime(long t){
		String unit;
		BigDecimal bd = new BigDecimal(t);
		if(t > 10 * 1000 * 1000 * 1000L){
			// 毫秒
			bd = bd.divide(new BigDecimal(1000 * 1000 * 1000L));
			unit = "s";
		}else if(t > 10 * 1000 * 1000) {
			// 毫秒
			bd = bd.divide(new BigDecimal(1000 * 1000L));
			unit = "ms";
		}else if(t > 10 * 1000) {
			// 微秒
			bd = bd.divide(new BigDecimal(1000));
			unit = "μs";
		}else{
			// 纳秒
			unit = "ns";
		}
		System.out.printf("time: %s%s\n", bd.toString(), unit);
	}

	private void printMemory(long m){
		BigDecimal bd = new BigDecimal(m);
		String unit;
		if(m > (1 << 30) * 10L){
			bd = bd.divide(new BigDecimal(1 << 30));
			unit = "GB";
		}else if(m > (1 << 20) * 10L){
			bd = bd.divide(new BigDecimal(1 << 20));
			unit = "MB";
		}else if(m > (1 << 10) * 10L){
			bd = bd.divide(new BigDecimal(1 << 10));
			unit = "kB";
		}else{
			unit = "B";
		}
		System.out.printf("memory: %s%s\n", bd.toString(), unit);
	}

	/**
	 * 对方法进行count次测试，并统计执行时间及消耗的内存
	 * @param count
	 * @param obj
	 * @param method
	 * @param params
	 * @return [time, memory]
	 */
	@SneakyThrows
	private long[] runMethod(int count, Object obj, Method method, Object... params){
		long time = 0, t1, t2, memory = 0, m1, m2;
		this.r.gc();
		for (int i = 0; i < count; i++){
			m1 = this.r.freeMemory();
			t1 = System.nanoTime();
			// TODO func
			method.invoke(obj, params);

			t2 = System.nanoTime();
			m2 = this.r.freeMemory();
			time += (t2 - t1);
			memory += (m1 - m2);
		}
		long t = time / count;
		long m = memory / count;
		return new long[]{t, m};
	}

	/**
	 * 对方法进行count次测试，并统计执行时间及消耗的内存
	 * @param count
	 * @param obj
	 * @param method
	 * @param ti
	 * @return [time, memory]
	 */
	@SneakyThrows
	private long[] runMethod(int count, Object obj, Method method, TestInfo ti){
		long time = 0, t1, t2, memory = 0, m1, m2;
		Object rs;
		Object[] params;
		this.r.gc();
		for (int i = 0; i < count; i++){
			params = ti.buildParams();
			m1 = this.r.freeMemory();
			t1 = System.nanoTime();
			// TODO func
			rs = method.invoke(obj, params);

			t2 = System.nanoTime();
			m2 = this.r.freeMemory();
			ti.print(params, rs);
			Assert.assertTrue(ti.verify(rs));
			time += (t2 - t1);
			memory += (m1 - m2);
		}
		long t = time / count;
		long m = memory / count;
		return new long[]{t, m};
	}

	@Override
	public boolean verify(Object rs) {
		return true;
	}

	@Override
	public Object[] buildParams() {
		return new Object[0];
	}

	@Override
	public void print(Object[] params, Object rs) {

	}
}
