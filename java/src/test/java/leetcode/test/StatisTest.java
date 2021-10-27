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

	public final static int DEFAULT_COUNT = 1000;
	public final static BigDecimal DEFAULT_COUNT_BD = new BigDecimal(1000);

	public final static BigDecimal MICRO_SECOND_BD = new BigDecimal(1000);
	public final static BigDecimal MILLI_SECOND_BD = new BigDecimal(1000 * 1000);
	public final static BigDecimal SECOND_BD = new BigDecimal(1000 * 1000 * 1000);

	public final static int MICRO_SECOND_NUM = 10 * 1000;
	public final static int MILLI_SECOND_NUM = 10 * 1000 * 1000;
	public final static int SECOND_NUM = 10 * 1000 * 1000 * 1000;

	public final static BigDecimal KILO_BYTE_BD = new BigDecimal(1 << 10);
	public final static BigDecimal MEGA_BYTE_BD = new BigDecimal(1 << 20);
	public final static BigDecimal GIGA_BYTE_BD = new BigDecimal(1 << 30);

	public final static int KILO_BYTE_NUM = (1 << 10) * 10;
	public final static int MEGA_BYTE_NUM = (1 << 20) * 10;
	public final static long GIGA_BYTE_NUM = (1 << 30) * 10L;

//	r.gc() 及其消耗时间 - 可以考虑放在for循环外
	private Runtime r = Runtime.getRuntime();

	private TestInfo ti;
	private BigDecimal standardTime;
	private BigDecimal standardMemory;

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
		this.standardTime = new BigDecimal(tm[0]).divide(StatisTest.DEFAULT_COUNT_BD);
		this.standardMemory = new BigDecimal(tm[1]).divide(StatisTest.DEFAULT_COUNT_BD);
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
	 * 单一参数
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
		this.ti.print(params, rs);
		Assert.assertTrue(this.ti.verify(params, rs));

		long[] tm = runMethod(count, obj, method, params);

		BigDecimal bd = new BigDecimal(count);
		System.out.printf("average ");
//		printTime(tm[0] / count - this.standardTime);
		printTime(new BigDecimal(tm[0]).divide(bd).subtract(this.standardTime));
		System.out.printf("average ");
//		printMemory(tm[1] / count - this.standardMemory);
		printMemory(new BigDecimal(tm[1]).divide(bd).subtract(this.standardMemory));
		System.out.println();
	}

	/**
	 * 对方法进行多次测试，不计算平均值
	 * @param count
	 * @param obj
	 * @param method
	 */
	@SneakyThrows
	public void doMethod(int count, Object obj, Method method){
		long[] tm = runMethod(count, obj, method, this.ti);

		BigDecimal bd = new BigDecimal(count);
//		printTime(tm[0] - this.standardTime.longValue() * count);
		printTime(new BigDecimal(tm[0]).subtract(this.standardTime.multiply(bd)));
//		printMemory(tm[1] - this.standardMemory.longValue() * count);
		printMemory(new BigDecimal(tm[1]).subtract(this.standardMemory.multiply(bd)));
		System.out.println();
	}

	private void printTime(BigDecimal bd){
		long t = bd.longValue();
		String unit;
		if(t > StatisTest.SECOND_NUM){
			// 秒
			bd = bd.divide(StatisTest.SECOND_BD);
			unit = "s";
		}else if(t > StatisTest.MILLI_SECOND_NUM) {
			// 毫秒
			bd = bd.divide(StatisTest.MILLI_SECOND_BD);
			unit = "ms";
		}else if(t > StatisTest.MICRO_SECOND_NUM) {
			// 微秒
			bd = bd.divide(StatisTest.MICRO_SECOND_BD);
			unit = "μs";
		}else{
			// 纳秒
			unit = "ns";
		}
		System.out.printf("time: %s%s\n", bd.toString(), unit);
	}

	private void printMemory(BigDecimal bd){
		long m = bd.longValue();
		String unit;
		if(m > StatisTest.GIGA_BYTE_NUM){
			bd = bd.divide(StatisTest.GIGA_BYTE_BD);
			unit = "GB";
		}else if(m > StatisTest.MEGA_BYTE_NUM){
			bd = bd.divide(StatisTest.MEGA_BYTE_BD);
			unit = "MB";
		}else if(m > StatisTest.KILO_BYTE_NUM){
			bd = bd.divide(StatisTest.KILO_BYTE_BD);
			unit = "kB";
		}else{
			unit = "B";
		}
		System.out.printf("memory: %s%s\n", bd.toString(), unit);
	}

	/**
	 * 单一输入对方法进行count次测试，并统计执行时间及消耗的内存，不计算平均值
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
		return new long[]{time, memory};
	}

	/**
	 * 多参数对方法进行count次测试，并统计执行时间及消耗的内存，不计算平均值
	 * @param count
	 * @param obj
	 * @param method
	 * @param ti
	 * @return [time, memory]
	 */
	@SneakyThrows
	private long[] runMethod(int count, Object obj, Method method, TestInfo ti){
		long time = 0, t1, t2, memory = 0, m1, m2;
		Object[] params;
		this.r.gc();
		for (int i = 0; i < count; i++){
			params = ti.buildParams();
			m1 = this.r.freeMemory();
			t1 = System.nanoTime();
			// TODO func
			Object rs = method.invoke(obj, params);

			t2 = System.nanoTime();
			m2 = this.r.freeMemory();
			ti.print(params, rs);
			Assert.assertTrue("result error", ti.verify(params, rs));
			time += (t2 - t1);
			memory += (m1 - m2);
		}
		return new long[]{time, memory};
	}

	@Override
	public boolean verify(Object[] params, Object rs) {
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
